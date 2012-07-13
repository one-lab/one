package com.sinosoft.web.instruction.reply;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.sinosoft.util.DateFormatMode;
import com.sinosoft.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.web.instruction.reply.transport.Text;

class AjaxReplyMaker<E> extends ReplyMaker implements AjaxReply<E> {
	private Class<? extends AbstractTransport> transport = Text.class;
	private E entity;

	private String[] excludes;
	private String[] includes;
	private DateFormatMode dateFormatMode;
	private String dateFormatString;
	
	public AjaxReplyMaker(E entity) {
		this.entity = entity;
	}
	
	@Override
	public AjaxReply<E> type(String mediaType) {
		super.setType(mediaType);
		return this;
	}

	@Override
	public AjaxReply<E> headers(Map<String, String> headers) {
		this.headers.putAll(headers);
		return this;
	}

	@Override
	public void populate(Invocation inv) throws IOException {
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
						entity);
			}
		}
	}

	@Override
	public AjaxReply<E> as(Class<? extends AbstractTransport> transport) {
		Preconditions.checkArgument(null != transport,
				"Transport class cannot be null!");
		this.transport = transport;
		return this;
	}

	@Override
	public AjaxReply<E> excludes(String excludeFields) {
		Preconditions.checkNotNull(excludeFields, "The exclude fields cannot be null.");
		return excludes(excludeFields.split(","));
	}

	@Override
	public AjaxReply<E> includes(String includeFields) {
		Preconditions.checkNotNull(includeFields, "The include fields cannot be null.");
		return includes(includeFields.split(","));
	}

	@Override
	public AjaxReply<E> dateFormatString(String dateFormatString) {
		if(Strings.isNullOrEmpty(dateFormatString)) {
			this.dateFormatString = DateFormatMode.YYYYMMDDHHMMSS.toString();
		} else {
			this.dateFormatString = dateFormatString;
		}
		return this;
	}

	@Override
	public AjaxReply<E> dateFormatMode(DateFormatMode dateFormatMode) {
		if(dateFormatMode == null) {
			this.dateFormatMode = DateFormatMode.YYYYMMDDHHMMSS;
		} else {
			this.dateFormatMode = dateFormatMode;
		}
		this.dateFormatString = this.dateFormatMode.toString();
		return this;
	}

	@Override
	public AjaxReply<E> excludes(String... excludeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.includes), "Invoked includes method, cannot inovke the excludes method at the same time.");
		this.excludes = excludeFields;
		return this;
	}

	@Override
	public AjaxReply<E> includes(String... includeFields) {
		Preconditions.checkState(ArrayUtils.isEmpty(this.excludes), "Invoked excludes method, cannot inovke the inlcudes method at the same time.");
		this.includes = includeFields;
		return this;
	}

	@Override
	public AjaxReply<E> status(int code) {
		setStatus(code);
		return this;
	}

}
