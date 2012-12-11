package com.sinosoft.one.mvc.web.instruction.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.sinosoft.one.mvc.web.instruction.reply.transport.AbstractTransport;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

import com.sinosoft.one.mvc.web.Invocation;

class SimpleJsonReplyMaker extends ReplyMaker implements
        SimpleJsonReply {
	private String sampleResultStatus = "success";
	private String sampleResultMessage = "";
	public SimpleJsonReply success() {
		return success("");
	}

	public SimpleJsonReply success(String successMessage) {
		return sampleResult("success", successMessage);
	}

	public SimpleJsonReply fail() {
		return fail("");
	}

	public SimpleJsonReply fail(String failMessage) {
		return this.sampleResult("fail", failMessage);
	}

	public SimpleJsonReply exception() {
		return exception("");
	}

	public SimpleJsonReply exception(String exceptionMessage) {
		return sampleResult("exception", exceptionMessage);
	}
	
	private SimpleJsonReply sampleResult(String status, String message) {
		this.sampleResultStatus = status;
		this.sampleResultMessage = message;
		return this;
	}
	
	public SimpleJsonReply type(String mediaType) {
		setType(mediaType);
		return this;
	}

	public SimpleJsonReply headers(Map<String, String> headers) {
		setHeaders(headers);
		return this;
	}

    public SimpleJsonReply header(String key, String value) {
        addHeader(key, value);
        return this;
    }

    public SimpleJsonReply status(int code) {
		setStatus(code);
		return this;
	}

	@Override
	public void populate(Invocation inv) throws IOException {
		HttpServletResponse response = inv.getResponse();
		AbstractTransport transport = inv.getApplicationContext().getBean(
				Json.class);

		setResponse(response, transport.contentType());
		Map<String, String> resultMap = new HashMap<String, String>(2);
		resultMap.put("status", this.sampleResultStatus);
		resultMap.put("message", this.sampleResultMessage);
		transport.out(response.getOutputStream(), resultMap);
		return;
	}

}
