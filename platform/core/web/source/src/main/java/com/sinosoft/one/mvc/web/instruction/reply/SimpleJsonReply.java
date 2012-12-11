package com.sinosoft.one.mvc.web.instruction.reply;

import java.util.Map;

public interface SimpleJsonReply extends Reply {
	/**
	 * Perform a 200 OK response with success body the body is
	 * {"status":"success", "message":""}
	 */
	SimpleJsonReply success();

	/**
	 * Perform a 200 OK response with success body the body is
	 * {"status":"success", "message":successMessage}
	 */
	SimpleJsonReply success(String successMessage);

	/**
	 * Perform a 200 OK response with fail body the body is {"status":"fail",
	 * "message":""}
	 */
	SimpleJsonReply fail();

	/**
	 * Perform a 200 OK response with fail body the body is {"status":"fail",
	 * "message":failMessage}
	 */
	SimpleJsonReply fail(String failMessage);

	/**
	 * Perform a 200 OK response with exception body the body is
	 * {"status":"exception", "message":""}
	 */
	SimpleJsonReply exception();

	/**
	 * Perform a 200 OK response with exception body the body is
	 * {"status":"exception", "message":exceptionMessage}
	 */
	SimpleJsonReply exception(String exceptionMessage);
	
	/**
	 * The media type of the response data to send to the client. I.e. the
	 * mime-type. Example {@code "application/json"} for JSON responses.
	 */
	SimpleJsonReply type(String mediaType);

	/**
	 * A Map of headers to set directly on the response.
	 */
	SimpleJsonReply headers(Map<String, String> headers);

    /**
     * header to set directly on the response.
     */
    SimpleJsonReply header(String key, String value);
	
	/**
	 * Set a custom status code (call this last, it will be overridden if other
	 * response code directives are called afterward).
	 */
	SimpleJsonReply status(int code);
}
