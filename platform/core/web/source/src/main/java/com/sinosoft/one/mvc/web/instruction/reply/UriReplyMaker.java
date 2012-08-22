package com.sinosoft.one.mvc.web.instruction.reply;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.one.mvc.web.Invocation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Preconditions;

class UriReplyMaker extends ReplyMaker implements UriReply {
	private final Log log = LogFactory.getLog(getClass());
	private String forwardUri;
	private String redirectUri;
	public UriReply type(String mediaType) {
		super.setType(mediaType);
		return this;
	}

	public UriReply headers(Map<String, String> headers) {
		super.setHeaders(headers);
		return this;
	}

    public UriReply header(String key, String value) {
        addHeader(key, value);
        return this;
    }
//	@Override
//	public UriReply seeOther(String uri) {
//		redirectUri = uri;
//		status = HttpServletResponse.SC_MOVED_PERMANENTLY;
//		return this;
//	}
//
//	@Override
//	public UriReply seeOther(String uri, int statusCode) {
//		Preconditions.checkArgument(statusCode >= 300 && statusCode < 400,
//				"Redirect statuses must be between 300-399");
//		redirectUri = uri;
//		status = statusCode;
//		return this;
//	}
//
//	@Override
//	public UriReply notFound() {
//		status = HttpServletResponse.SC_NOT_FOUND;
//		return this;
//	}
//
//	@Override
//	public UriReply unauthorized() {
//		status = HttpServletResponse.SC_UNAUTHORIZED;
//		return this;
//	}


	public UriReply redirect(String url) {
		StringsEx.nonEmpty(url, "Redirect URL must be non empty!");
		this.redirectUri = url;
		status = HttpServletResponse.SC_MOVED_TEMPORARILY;
		return this;
	}
	
	

//	@Override
//	public UriReply forbidden() {
//		status = HttpServletResponse.SC_FORBIDDEN;
//		return this;
//	}
//
//	@Override
//	public UriReply noContent() {
//		status = HttpServletResponse.SC_NO_CONTENT;
//		return this;
//	}
//
//	@Override
//	public UriReply error() {
//		status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
//		return this;
//	}
//
//	@Override
//	public UriReply ok() {
//		status = HttpServletResponse.SC_OK;
//		return this;
//	}

	@Override
	public void populate(Invocation inv) throws IOException {
		if (Replys.NO_REPLY == this) {
			inv.getRequest().setAttribute(Replys.NO_REPLY_ATTR, Boolean.TRUE);
			return;
		}
		HttpServletResponse response = inv.getResponse();
		if (null != redirectUri) {
			response.sendRedirect(redirectUri);
			return;
		} 
		if(null != forwardUri) {
			HttpServletRequest request = inv.getRequest();
			try {
				Map<String, Object> attributes = inv.getModel().getAttributes();
				for(String key : attributes.keySet()) {
					request.setAttribute(key, attributes.get(key));
				}
				request.getRequestDispatcher(forwardUri).forward(request, response);
			} catch (ServletException e) {
				log.error("forward exception, the forward uri is " + forwardUri, e);
			}
			return;
		}
	}

	public UriReply forward(String url) {
		StringsEx.nonEmpty(url, "Redirect URL must be non empty!");
		this.forwardUri = url;
		return this;
	}

	public UriReply status(int code) {
		super.setStatus(code);
		return this;
	}

}
