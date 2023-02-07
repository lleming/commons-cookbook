package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CountingInputStream;
import org.junit.Assert;
import org.junit.Test;

public class CountableBytesStreamTest {

  @Test
  public void testCountBytesInStream() throws IOException {
    CountingInputStream input = null;
    OutputStream output = null;
    try {
      input =
          new CountingInputStream(new ByteArrayInputStream("hello my dear friend".getBytes(StandardCharsets.UTF_8)));
      output = new ByteArrayOutputStream(1024);
      IOUtils.copy(input, output);
      Assert.assertEquals(20, input.getCount());

    } finally {
      IOUtils.closeQuietly(input);
      IOUtils.closeQuietly(output);
    }
  }

}
