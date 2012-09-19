package com.sinosoft.one.mvc.web.instruction.reply.transport;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import com.google.common.io.ByteStreams;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
@Component
class SimpleTextTransport extends Text {

    public <T> void out(OutputStream out, T data) {
      try {
        ByteStreams.copy(new ByteArrayInputStream(data.toString().getBytes()), out);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
}
