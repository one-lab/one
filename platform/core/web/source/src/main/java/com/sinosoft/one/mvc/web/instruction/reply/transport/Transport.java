package com.sinosoft.one.mvc.web.instruction.reply.transport;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
public interface Transport {

  /**
   * Converts a given object into transportable data and writes it to the provided
   * OutputStream.
   *
   * @param out An open outputstream to write to. This stream will NOT be closed.
   * @param data An object representing the data to be written out.

   * @throws IOException Thrown if there is an error writing to this stream.
   */
  <T> void out(OutputStream out, T data) throws IOException;

  /**
   * Returns the HTTP content type marshalled by this transport. For example, the
   * transport transforms plain
   * strings to and from the HTTP stream. Its content type is {@code text/plain}. This
   * is only a default (or suggested) content type. You may of course, return whatever
   * content type is most suitable if using this transport to deliver web responses.
   *
   * @return A non-empty string representing a HTTP content (mime) type. 
   */
  String contentType();
}
