package com.sinosoft.web.instruction.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sinosoft.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.web.instruction.reply.transport.Json;

import net.paoding.rose.web.Invocation;

class SampleJsonReplyMaker extends ReplyMaker implements
		SampleJsonReply {
	private String sampleResultStatus = "success";
	private String sampleResultMessage = "";
	@Override
	public SampleJsonReply success() {
		return success("");
	}

	@Override
	public SampleJsonReply success(String successMessage) {
		return sampleResult("success", successMessage);
	}

	@Override
	public SampleJsonReply fail() {
		return fail("");
	}

	@Override
	public SampleJsonReply fail(String failMessage) {
		return this.sampleResult("fail", failMessage);
	}

	@Override
	public SampleJsonReply exception() {
		return exception("");
	}

	@Override
	public SampleJsonReply exception(String exceptionMessage) {
		return sampleResult("exception", exceptionMessage);
	}
	
	private SampleJsonReply sampleResult(String status, String message) {
		this.sampleResultStatus = status;
		this.sampleResultMessage = message;
		return this;
	}
	
	@Override
	public SampleJsonReply type(String mediaType) {
		setType(mediaType);
		return this;
	}

	@Override
	public SampleJsonReply headers(Map<String, String> headers) {
		setHeaders(headers);
		return this;
	}

	@Override
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
