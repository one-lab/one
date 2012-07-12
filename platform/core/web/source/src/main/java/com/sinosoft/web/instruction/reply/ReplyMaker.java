package com.sinosoft.web.instruction.reply;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import com.sinosoft.util.DateFormatMode;
import com.sinosoft.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.web.instruction.reply.transport.Json;
import com.sinosoft.web.instruction.reply.transport.Text;

/**
 * A builder implementation of the Reply interface.
 */
class ReplyMaker<E> extends Reply<E> {
	Log log = LogFactory.getLog(getClass());
	// By default, we cool.
	private int status = HttpServletResponse.SC_OK;

	private String contentType;

	private String forwardUri;
	private String redirectUri;
	private Map<String, String> headers = Maps.newHashMap();

	private Class<? extends AbstractTransport> transport = Text.class;
	private E entity;

	private String[] excludes;
	private String[] includes;
	private DateFormatMode dateFormatMode;
	private String dateFormatString;
	private String sampleResultStatus = "success";
	private String sampleResultMessage = "";
	private boolean isSampleReply;

	public ReplyMaker(E entity) {
		this.entity = entity;
	}
	
    protected ReplyMaker(boolean isSampleReply) {
    	this.isSampleReply = isSampleReply;
    }

	@Override
	public Reply<E> seeOther(String uri) {
		redirectUri = uri;
		status = HttpServletResponse.SC_MOVED_PERMANENTLY;
		return this;
	}

	@Override
	public Reply<E> seeOther(String uri, int statusCode) {
		Preconditions.checkArgument(statusCode >= 300 && statusCode < 400,
				"Redirect statuses must be between 300-399");
		redirectUri = uri;
		status = statusCode;
		return this;
	}

	@Override
	public Reply<E> type(String mediaType) {
		StringsEx.nonEmpty(mediaType, "Media type cannot be null or empty");
		this.contentType = mediaType;
		return this;
	}

	@Override
	public Reply<E> headers(Map<String, String> headers) {
		this.headers.putAll(headers);
		return this;
	}

	@Override
	public Reply<E> notFound() {
		status = HttpServletResponse.SC_NOT_FOUND;
		return this;
	}

	@Override
	public Reply<E> unauthorized() {
		status = HttpServletResponse.SC_UNAUTHORIZED;
		return this;
	}

	@Override
	public Reply<E> as(Class<? extends AbstractTransport> transport) {
		Preconditions.checkArgument(null != transport,
				"Transport class cannot be null!");
		this.transport = transport;
		return this;
	}

	@Override
	public Reply<E> redirect(String url) {
		StringsEx.nonEmpty(url, "Redirect URL must be non empty!");
		this.redirectUri = url;
		status = HttpServletResponse.SC_MOVED_TEMPORARILY;
		return this;
	}

	@Override
	public Reply<E> forbidden() {
		status = HttpServletResponse.SC_FORBIDDEN;
		return this;
	}

	@Override
	public Reply<E> noContent() {
		status = HttpServletResponse.SC_NO_CONTENT;
		return this;
	}

	@Override
	public Reply<E> error() {
		status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		return this;
	}

	@Override
	public Reply<E> status(int code) {
		status = code;
		return this;
	}

	@Override
	public Reply<E> ok() {
		status = HttpServletResponse.SC_OK;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	void populate(Invocation inv) throws IOException {
		// If we should not bother with the chain

		if (Reply.NO_REPLY == this) {
			inv.getRequest().setAttribute(Reply.NO_REPLY_ATTR, Boolean.TRUE);
			return;
		}
		HttpServletResponse response = inv.getResponse();
		// This is where we take all the builder values and encode them in the
		// response.
		AbstractTransport transport = inv.getApplicationContext().getBean(
				this.transport);

		// Set any headers (we do this first, so we can override any cheekily
		// set headers).
		if (!headers.isEmpty()) {
			for (Map.Entry<String, String> header : headers.entrySet()) {
				response.setHeader(header.getKey(), header.getValue());
			}
		}

		// If the content type was already set, do nothing.
		if (response.getContentType() == null) {
			// By default we use the content type of the transport.
			if (null == contentType) {
				response.setContentType(transport.contentType());
			} else {
				response.setContentType(contentType);
			}
		}

		// Send redirect
		if (null != redirectUri) {
			response.sendRedirect(redirectUri);
			response.setStatus(status); // HACK to override whatever status the
										// redirect sets.
			return;
		} 
		if(null != forwardUri) {
			HttpServletRequest request = inv.getRequest();
			try {
				request.getRequestDispatcher(forwardUri).forward(request, response);
			} catch (ServletException e) {
				log.error("forward exception, the forward uri is " + forwardUri, e);
			}
			response.setStatus(status); 
			return;
		}

		// Write out data.
		response.setStatus(status);
		
		if(isSampleReply) {
			transport = inv.getApplicationContext().getBean(
					Json.class);
			Map<String, String> resultMap = new HashMap<String, String>(2);
			resultMap.put("status", this.sampleResultStatus);
			resultMap.put("message", this.sampleResultMessage);
			transport.out(response.getOutputStream(), Map.class, resultMap);
			return;
		}

		if (null != entity) {
			if (entity instanceof InputStream) {
				// Stream the response rather than marshalling it through a
				// transport.
				InputStream inputStream = (InputStream) entity;
				try {
					ByteStreams.copy(inputStream, response.getOutputStream());
				} finally {
					inputStream.close();
				}
			} else {
				if(StringUtils.isEmpty(dateFormatString)) {
					dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
				}
				transport.setDateFormatString(dateFormatString);
				if(ArrayUtils.isNotEmpty(excludes)) {
					transport.setExcludes(excludes);
					transport.setIncludes(null);
				} else if(ArrayUtils.isNotEmpty(includes)) {
					transport.setIncludes(includes);
					transport.setExcludes(null);
				} else {
					transport.setIncludes(null);
					transport.setExcludes(null);
				}
				// TODO(dhanji): This feels wrong to me. We need a better way to
				// obtain the entity type.
				transport.out(response.getOutputStream(),
						(Class<E>) entity.getClass(), entity);
			}
		}
	}

	@Override
	public Reply<E> excludes(String excludeFields) {
		Preconditions.checkNotNull(excludeFields, "The exclude fields cannot be null.");
		return excludes(excludeFields.split(","));
	}

	@Override
	public Reply<E> includes(String includeFields) {
		Preconditions.checkNotNull(includeFields, "The include fields cannot be null.");
		return includes(includeFields.split(","));
	}

	@Override
	public Reply<E> dateFormatString(String dateFormatString) {
		if(Strings.isNullOrEmpty(dateFormatString)) {
			this.dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
		} else {
			this.dateFormatString = dateFormatString;
		}
		return this;
	}

	@Override
	public Reply<E> dateFormatMode(DateFormatMode dateFormatMode) {
		if(dateFormatMode == null) {
			this.dateFormatMode = DateFormatMode.YYYYMMDDHHMMSS;
		} else {
			this.dateFormatMode = dateFormatMode;
		}
		this.dateFormatString = this.dateFormatMode.toString();
		return this;
	}

	@Override
	public Reply<E> excludes(String... excludeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.includes), "Invoked includes method, cannot inovke the excludes method at the same time.");
		this.excludes = excludeFields;
		return this;
	}

	@Override
	public Reply<E> includes(String... includeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.excludes), "Invoked excludes method, cannot inovke the inlcudes method at the same time.");
		this.includes = includeFields;
		return this;
	}

	@Override
	public Reply<E> success() {
		return success("");
	}

	@Override
	public Reply<E> success(String successMessage) {
		return sampleResult("success", successMessage);
	}

	@Override
	public Reply<E> fail() {
		return fail("");
	}

	@Override
	public Reply<E> fail(String failMessage) {
		return this.sampleResult("fail", failMessage);
	}

	@Override
	public Reply<E> exception() {
		return exception("");
	}

	@Override
	public Reply<E> exception(String exceptionMessage) {
		return sampleResult("exception", exceptionMessage);
	}

	private Reply<E> sampleResult(String status, String message) {
		this.sampleResultStatus = status;
		this.sampleResultMessage = message;
		return this;
	}
	@Override
	public Reply<E> forward(String uri) {
		this.forwardUri = uri;
		return this;
	}
}
