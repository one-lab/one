package com.sinosoft.one.mvc.web.instruction.reply;

import java.util.Map;

public interface SampleJsonReply extends Reply {
	/**
	 * Perform a 200 OK response with success body the body is
	 * {"status":"success", "message":""}
	 */
	SampleJsonReply success();

	/**
	 * Perform a 200 OK response with success body the body is
	 * {"status":"success", "message":successMessage}
	 */
	SampleJsonReply success(String successMessage);

	/**
	 * Perform a 200 OK response with fail body the body is {"status":"fail",
	 * "message":""}
	 */
	SampleJsonReply fail();

	/**
	 * Perform a 200 OK response with fail body the body is {"status":"fail",
	 * "message":failMessage}
	 */
	SampleJsonReply fail(String failMessage);

	/**
	 * Perform a 200 OK response with exception body the body is
	 * {"status":"exception", "message":""}
	 */
	SampleJsonReply exception();

	/**
	 * Perform a 200 OK response with exception body the body is
	 * {"status":"exception", "message":exceptionMessage}
	 */
	SampleJsonReply exception(String exceptionMessage);
	
	/**
	 * The media type of the response data to send to the client. I.e. the
	 * mime-type. Example {@code "application/json"} for JSON responses.
	 */
	SampleJsonReply type(String mediaType);

	/**
	 * A Map of headers to set directly on the response.
	 */
	SampleJsonReply headers(Map<String, String> headers);

    /**
     * header to set directly on the response.
     */
    SampleJsonReply header(String key, String value);
	
	/**
	 * Set a custom status code (call this last, it will be overridden if other
	 * response code directives are called afterward).
	 */
	SampleJsonReply status(int code);
}
