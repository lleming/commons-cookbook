package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class LoadXmlIntoBeanTest {
    @Test
    public void testLoadPlayXml() throws IOException, SAXException {
        List plays = new ArrayList();
        URL rules = getClass().getClassLoader().getResource("digester-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);
        digester.push(plays);
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("play.xml")) {
            Object root = digester.parse(input);
            Play hamlet = (Play) plays.get(0);
            List characters = (List) hamlet.getCharacters();
            Assert.assertEquals(1, plays.size());
            Assert.assertEquals(3, characters.size());
            Character character = (Character) characters.get(0);
            Character expected = new Character();
            expected.setName("Claudius");
            expected.setProtagonist(false);
            Assert.assertEquals(expected, character);
        }

    }
}
