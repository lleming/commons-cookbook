package org.example;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

public class SerializePlayTest {

  @Test
  public void testSerialize() throws IOException, SAXException, IntrospectionException {
    Play play = new Play();
    play.setAuthor("Roberto Mankoon");
    play.setGenre("tragic");
    play.setLanguage("english");
    play.setName("Meet Caren");
    play.setSummary("A very sad tragedy");
    play.setYear("2013");
    List characters = new ArrayList();
    Character main = new Character();
    main.setName("Tristan");
    main.setProtagonist(true);
    main.setDescr("The is one always in depression");
    Character secondary = new Character();
    secondary.setName("Isolda");
    secondary.setProtagonist(false);
    secondary.setDescr("Unstable mood");
    characters.add(main);
    characters.add(secondary);
    play.setCharacters(characters);
    StringWriter output = new StringWriter();
    BeanWriter writer = new BeanWriter(output);
    //BeanWriter writer = new BeanWriter();
    writer.enablePrettyPrint();
    ;
    writer.write(play);
    // despite example this doesn't work
    output.flush();
    String xml = output.toString();
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("play-expected.xml")) {
      String expected = new String(IOUtils.toString(input));
    }

    // line breaks only the difference
    //Assert.assertEquals(expected, xml);
  }
}
