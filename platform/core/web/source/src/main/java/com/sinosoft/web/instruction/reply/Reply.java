package com.sinosoft.web.instruction.reply;

import java.io.IOException;
import java.util.Map;

import net.paoding.rose.web.Invocation;

import com.sinosoft.util.DateFormatMode;
import com.sinosoft.web.instruction.reply.transport.AbstractTransport;

/**
 * Web请求统一响应类.
 */
public abstract class Reply<E> {
  // Asks sitebricks to continue down the servlet processing chain
  public static final Reply<?> NO_REPLY = Reply.saying();

  public static final String NO_REPLY_ATTR = "sb_no_reply";

  /**
   * Perform a 301 redirect (moved permanently) to the given uri.
   */
  public abstract Reply<E> seeOther(String uri);

  /**
   * Perform a custom redirect to the given uri. The status code must be
   * in the 3XX range.
   */
  public abstract Reply<E> seeOther(String uri, int statusCode);

  /**
   * The media type of the response data to send to the client. I.e.
   * the mime-type. Example {@code "application/json"} for JSON responses.
   */
  public abstract Reply<E> type(String mediaType);

  /**
   * A Map of headers to set directly on the response.
   */
  public abstract Reply<E> headers(Map<String, String> headers);

  /**
   * Perform a 404 not found reply.
   */
  public abstract Reply<E> notFound();

  /**
   * Perform a 401 not authorized reply.
   */
  public abstract Reply<E> unauthorized();

  /**
   * Directs sitebricks to use the given Guice key as a transport to
   * marshall the provided entity to the client. Example:
   * <pre>
   *   return Reply.with(new Person(..)).as(Xml.class);
   * </pre>
   * <p>
   * Will marhall the given Person object into XML using the Guice Key
   * bound to [Xml.class] (by default this is an XStream based XML
   * transport).
   */
  public abstract Reply<E> as(Class<? extends AbstractTransport> transport);

  /**
   * Perform a 302 redirect to the given uri (moved temporarily).
   */
  public abstract Reply<E> redirect(String uri);

  /**
   * Perform a 403 resource forbidden error response.
   */
  public abstract Reply<E> forbidden();

  /**
   * Perform a 204 no content response.
   */
  public abstract Reply<E> noContent();

  /**
   * Perform a 500 general error response.
   */
  public abstract Reply<E> error();


  /**
   * Set a custom status code (call this last, it will be overridden if
   * other response code directives are called afterward).
   */
  public abstract Reply<E> status(int code);

  /**
   * Perform a 200 OK response with no body.
   */
  public abstract Reply<E> ok();
  
  /**
   * Perform a 200 OK response with success body
   * the body is {"status":"success", "message":""}
   */
  public abstract Reply<E> success();
  /**
   * Perform a 200 OK response with success body
   * the body is {"status":"success", "message":successMessage}
   */
  public abstract Reply<E> success(String successMessage);
  /**
   * Perform a 200 OK response with fail body
   * the body is {"status":"fail", "message":""}
   */
  public abstract Reply<E> fail();
  
  /**
   * Perform a 200 OK response with fail body
   * the body is {"status":"fail", "message":failMessage}
   */
  public abstract Reply<E> fail(String failMessage);
  
  /**
   * Perform a 200 OK response with exception body
   * the body is {"status":"exception", "message":""}
   */
  public abstract Reply<E> exception();
  
  /**
   * Perform a 200 OK response with exception body
   * the body is {"status":"exception", "message":exceptionMessage}
   */
  public abstract Reply<E> exception(String exceptionMessage);
  
  /**
   * Perform a forward to the given uri .
   */
  public abstract Reply<E> forward(String uri);
  
  /**
   * When as json.class or xml.class exclude some fields
   * @param excludeFields to exclude fields<br />
   * 	the fields format is "firstField,secondField,...,lastField"
   * @return
   */
  public abstract Reply<E> excludes(String excludeFields);
  
  /**
   * When parse as json.class or xml.class include some fields
   * @param excludeFields to include fields<br />
   * 	the fields format is "firstField,secondField,...,lastField"
   * @return
   */
  public abstract Reply<E> includes(String includeFields);
  
  /**
   * When parse as json.class or xml.class exclude some fields
   * @param excludeFields to exclude fields array
   * @return
   */
  public abstract Reply<E> excludes(String... excludeFields);
  
  /**
   * When as json.class or xml.class exclude some fields
   * @param excludeFields to exclude fields array
   * @return
   */
  public abstract Reply<E> includes(String... includeFields);
  
  /**
   * When parse as json.class or xml.class set the special date format
   * @param dateFormatString date format string eg. "yyyy-MM-dd HH:mm:ss"<br/>
   * 	the default format is "yyyy-MM-dd HH:mm:ss"
   * @return
   */
  public abstract Reply<E> dateFormatString(String dateFormatString);
  
  /**
   * When parse as json.class or xml.class set the special date format
   * @param dateFormatString date format string eg. "yyyy-MM-dd HH:mm:ss"<br/>
   * 	the default format is "yyyy-MM-dd HH:mm:ss"
   * @return
   */
  public abstract Reply<E> dateFormatMode(DateFormatMode dateFormatMode);

  /**
   * Used internally by sitebricks. Do NOT call.
   */
  abstract void populate(Invocation inv) throws IOException;

  /**
   * Convenience method to make a reply without any entity or body. Example, to send a redirect:
   * <pre>
   *   return Reply.saying().redirect("/other");
   * </pre>
   */
  public static <E> Reply<E> saying() {
    return new ReplyMaker<E>(null);
  }

  /**
   * Returns a reply with an entity that is sent back to the client via the specified
   * transport.
   *
   * @param entity An entity to send back for which a valid transport exists (see
   *   {@link #as(Class)}).
   */
  public static <E> Reply<E> with(E entity) {
    return new ReplyMaker<E>(entity);
  }
  
  public static <E> Reply<E> sample() {
	  return new ReplyMaker<E>(true);
  }
}
