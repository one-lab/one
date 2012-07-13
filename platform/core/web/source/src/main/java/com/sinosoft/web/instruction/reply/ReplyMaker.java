package com.sinosoft.web.instruction.reply;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Maps;

import net.paoding.rose.web.Invocation;

abstract class ReplyMaker implements Reply {
	int status = HttpServletResponse.SC_OK;
	String contentType;
	Map<String, String> headers = Maps.newHashMap();
	void setType(String mediaType) {
		StringsEx.nonEmpty(mediaType, "Media type cannot be null or empty");
		this.contentType = mediaType;
	}

	void setHeaders(Map<String, String> headers) {
		this.headers.putAll(headers);
	}
	
	void setStatus(int statusCode) {
		this.status = statusCode;
	}

	public abstract void populate(Invocation inv) throws IOException ;

}
