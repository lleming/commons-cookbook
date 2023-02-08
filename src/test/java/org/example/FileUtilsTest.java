package org.example;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {

  @Test
  public void testHumanReadableFilesize1Mb() {
    String size = FileUtils.byteCountToDisplaySize(1_000_000);
    Assert.assertEquals("976 KB", size);
  }

  @Test
  public void  testHumanReadableFileSize2Mb(){
    String size = FileUtils.byteCountToDisplaySize(2_000_000);
    Assert.assertEquals("1 MB", size);
  }

}
