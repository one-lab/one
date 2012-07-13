package com.sinosoft.web.instruction.reply.transport;


/**
 * A plain text (UTF-8) implementation of Transport where input types are assumed
 * to be Strings.
 *
 * @author dhanji@google.com (Dhanji R. Prasanna)
 */
public abstract class Xml extends AbstractTransport {

  public String contentType() {
    return "text/xml";
  }
}