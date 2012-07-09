package net.paoding.rose.web.instruction.reply.transport;

import net.paoding.rose.web.instruction.reply.Transport;

/**
 * A raw implementation of Transport where input types are assumed
 * to be byte arrays.
 *
 * @author dhanji@google.com (Dhanji R. Prasanna)
 */
public abstract class Raw implements Transport {

  public String contentType() {
    return "application/octet-stream";
  }
}