package com.sinosoft.one.mvc.web.instruction.reply.transport;


/**
 * A raw implementation of Transport where input types are assumed
 * to be byte arrays.
 *
 * @author dhanji@google.com (Dhanji R. Prasanna)
 */
public abstract class Raw  extends AbstractTransport {

  public String contentType() {
    return "application/octet-stream";
  }
}