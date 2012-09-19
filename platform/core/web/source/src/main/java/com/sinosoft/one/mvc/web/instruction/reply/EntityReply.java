package com.sinosoft.one.mvc.web.instruction.reply;

import java.util.Map;

import com.sinosoft.one.mvc.util.DateFormatMode;
import com.sinosoft.one.mvc.web.instruction.reply.transport.AbstractTransport;

public interface EntityReply<E> extends Reply {
	/**
	 * Directs sitebricks to use the given Guice key as a transport to marshall
	 * the provided entity to the client. Example:
	 * 
	 * <pre>
	 *   return Reply.with(new Person(..)).as(Xml.class);
	 * </pre>
	 * <p>
	 * Will marhall the given Person object into XML using the Guice Key bound
	 * to [Xml.class] (by default this is an XStream based XML transport).
	 */
	EntityReply<E> as(Class<? extends AbstractTransport> transport);

	/**
	 * When as json.class or xml.class exclude some fields
	 * 
	 * @param excludeFields
	 *            to exclude fields<br />
	 *            the fields format is "firstField,secondField,...,lastField"
	 * @return
	 */
	EntityReply<E> excludes(String excludeFields);

	/**
	 * When parse as json.class or xml.class include some fields
	 * 
	 * @param includeFields
	 *            to include fields<br />
	 *            the fields format is "firstField,secondField,...,lastField"
	 * @return
	 */
	EntityReply<E> includes(String includeFields);

	/**
	 * When parse as json.class or xml.class exclude some fields
	 * 
	 * @param excludeFields
	 *            to exclude fields array
	 * @return
	 */
	EntityReply<E> excludes(String... excludeFields);

	/**
	 * When as json.class or xml.class exclude some fields
	 * 
	 * @param includeFields
	 *            to exclude fields array
	 * @return
	 */
	EntityReply<E> includes(String... includeFields);

	/**
	 * When parse as json.class or xml.class set the special date format
	 * 
	 * @param dateFormatString
	 *            date format string eg. "yyyy-MM-dd HH:mm:ss"<br/>
	 *            the default format is "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	EntityReply<E> dateFormatString(String dateFormatString);

	/**
	 * When parse as json.class or xml.class set the special date format
	 * 
	 * @param dateFormatMode
	 *            date format mode eg. DateFormatMode.YYYYMMDDHHMMSS<br/>
	 *            the default format is DateFormatMode.YYYYMMDDHHMMSS
	 * @return
	 */
	EntityReply<E> dateFormatMode(DateFormatMode dateFormatMode);

	/**
	 * The media type of the response data to send to the client. I.e. the
	 * mime-type. Example {@code "application/json"} for JSON responses.
	 */
	EntityReply<E> type(String mediaType);

	/**
	 * A Map of headers to set directly on the response.
	 */
	EntityReply<E> headers(Map<String, String> headers);

    /**
     * a header to set directly on the response.
     */
    EntityReply<E> header(String key, String value);

    /**
     * a header to set directly on the response.
     */
    EntityReply<E> downloadFileName(String fileName);
	
	/**
	 * Set a custom status code (call this last, it will be overridden if other
	 * response code directives are called afterward).
	 */
	EntityReply<E> status(int code);
}
