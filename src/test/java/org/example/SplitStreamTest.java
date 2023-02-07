package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.junit.Assert;
import org.junit.Test;

public class SplitStreamTest {

  private static final Charset UTF_8 = StandardCharsets.UTF_8;
  private String data = "some minor example is important";

  @Test
  public void testSplitStream() throws IOException {
    InputStream input = null;
    ByteArrayOutputStream output0 = new ByteArrayOutputStream(1024);
    ByteArrayOutputStream output1 = new ByteArrayOutputStream(1024);
    try {

      input = new ByteArrayInputStream(data.getBytes(UTF_8));
      OutputStream output = new TeeOutputStream(output0, output1);
      IOUtils.copy(input, output);
      IOUtils.closeQuietly(output);
    } finally {
      IOUtils.closeQuietly(input);
    }
    Assert.assertEquals(data, new String(output0.toByteArray(), UTF_8));
    Assert.assertEquals(data, new String(output1.toByteArray(), UTF_8));
  }
}
