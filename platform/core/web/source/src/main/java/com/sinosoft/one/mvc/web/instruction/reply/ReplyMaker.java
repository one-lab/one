package com.sinosoft.one.mvc.web.instruction.reply;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import com.sinosoft.one.mvc.web.Invocation;

abstract class ReplyMaker implements Reply {
	int status = HttpServletResponse.SC_OK;
	String contentType;
	Map<String, String> headers = Maps.newHashMap();
	void setType(String mediaType) {
		StringsEx.nonEmpty(mediaType, "Media type cannot be null or empty");
		this.contentType = mediaType;
	}

	void setHeaders(Map<String, String> headers) {
        if(headers != null && !headers.isEmpty()) {
		    this.headers.putAll(headers);
        }
	}

    void addHeader(String key, String value) {
        StringsEx.nonEmpty(key, "Key cannot be null or empty");
        StringsEx.nonEmpty(value, "Value cannot be null or empty");
        this.headers.put(key, value);
    }
	
	void setStatus(int statusCode) {
        Preconditions.checkArgument(status < 0, "status code must greater than 0.");
		this.status = statusCode;
	}

    void setResponse(HttpServletResponse response, String transportContentType) {
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
                response.setContentType(transportContentType);
            } else {
                response.setContentType(contentType);
            }
        }
    }
	abstract void populate(Invocation inv) throws IOException ;

}
