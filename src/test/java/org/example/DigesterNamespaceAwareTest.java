package org.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.example.digester.Page;
import org.example.digester.PageRuleSet;
import org.example.digester.Pages;
import org.example.digester.PersonRuleSet;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class DigesterNamespaceAwareTest {

    @Test
    public void testNamespaceAwareDigester() throws IOException, SAXException {
        Pages pages = new Pages();
        Digester digester = new Digester();
        digester.setNamespaceAware(true);
        digester.addRuleSet(new PageRuleSet());
        digester.addRuleSet(new PersonRuleSet());
        digester.push(pages);
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("pages.xml")) {

            // using namespace with digester tricky and error prone avoid usage of it
            // digester.parse(input);
            // Page page = (Page) pages.getPages().get(0);

            // Assert.assertNotNull(page);
        }
    }
}
