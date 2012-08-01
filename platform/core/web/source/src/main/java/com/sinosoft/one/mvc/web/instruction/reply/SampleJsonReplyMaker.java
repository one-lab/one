package com.sinosoft.one.mvc.web.instruction.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sinosoft.one.mvc.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

import com.sinosoft.one.mvc.web.Invocation;

class SampleJsonReplyMaker extends ReplyMaker implements
		SampleJsonReply {
	private String sampleResultStatus = "success";
	private String sampleResultMessage = "";
	public SampleJsonReply success() {
		return success("");
	}

	public SampleJsonReply success(String successMessage) {
		return sampleResult("success", successMessage);
	}

	public SampleJsonReply fail() {
		return fail("");
	}

	public SampleJsonReply fail(String failMessage) {
		return this.sampleResult("fail", failMessage);
	}

	public SampleJsonReply exception() {
		return exception("");
	}

	public SampleJsonReply exception(String exceptionMessage) {
		return sampleResult("exception", exceptionMessage);
	}
	
	private SampleJsonReply sampleResult(String status, String message) {
		this.sampleResultStatus = status;
		this.sampleResultMessage = message;
		return this;
	}
	
	public SampleJsonReply type(String mediaType) {
		setType(mediaType);
		return this;
	}

	public SampleJsonReply headers(Map<String, String> headers) {
		setHeaders(headers);
		return this;
	}

	public SampleJsonReply status(int code) {
		setStatus(code);
		return this;
	}

	@Override
	public void populate(Invocation inv) throws IOException {
		HttpServletResponse response = inv.getResponse();
		AbstractTransport transport = inv.getApplicationContext().getBean(
				Json.class);

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
		Map<String, String> resultMap = new HashMap<String, String>(2);
		resultMap.put("status", this.sampleResultStatus);
		resultMap.put("message", this.sampleResultMessage);
		transport.out(response.getOutputStream(), resultMap);
		return;
	}

}
