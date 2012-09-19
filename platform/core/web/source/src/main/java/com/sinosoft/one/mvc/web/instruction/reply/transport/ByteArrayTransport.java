package com.sinosoft.one.mvc.web.instruction.reply.transport;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
@Component
class ByteArrayTransport extends Raw {

  public <T> void out(OutputStream out, T data) throws IOException {
    assert data instanceof byte[];
    out.write((byte[]) data);
  }
}