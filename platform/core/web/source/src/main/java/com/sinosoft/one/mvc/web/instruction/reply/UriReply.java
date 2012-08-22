package com.sinosoft.one.mvc.web.instruction.reply;

import java.util.Map;

public interface UriReply extends Reply {
	/**
	 * Perform a 301 redirect (moved permanently) to the given uri.
	 */
	//UriReply seeOther(String uri);

	/**
	 * Perform a custom redirect to the given uri. The status code must be in
	 * the 3XX range.
	 */
	//UriReply seeOther(String uri, int statusCode);

	/**
	 * Perform a 404 not found reply.
	 */
	//UriReply notFound();

	/**
	 * Perform a 401 not authorized reply.
	 */
	//UriReply unauthorized();

	/**
	 * Perform a 302 redirect to the given uri (moved temporarily).
	 */
	UriReply redirect(String uri);

	/**
	 * Perform a forward to the given uri .
	 */
	UriReply forward(String uri);

	/**
	 * Perform a 403 resource forbidden error response.
	 */
	//UriReply forbidden();

	/**
	 * Perform a 204 no content response.
	 */
	//UriReply noContent();

	/**
	 * Perform a 500 general error response.
	 */
	//UriReply error();

	/**
	 * Perform a 200 OK response with no body.
	 */
	//UriReply ok();

	/**
	 * The media type of the response data to send to the client. I.e. the
	 * mime-type. Example {@code "application/json"} for JSON responses.
	 */
	UriReply type(String mediaType);

	/**
	 * A Map of headers to set directly on the response.
	 */
	UriReply headers(Map<String, String> headers);

    /**
     * header to set directly on the response.
     */
    UriReply header(String key, String value);
	
	/**
	 * Set a custom status code (call this last, it will be overridden if other
	 * response code directives are called afterward).
	 */
	UriReply status(int code);
	
}
