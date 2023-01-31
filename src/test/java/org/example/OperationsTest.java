package org.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.example.digester.EmailRule;
import org.example.digester.LowerRule;
import org.example.digester.Message;
import org.example.digester.ReplaceRule;
import org.example.digester.ReverseRule;
import org.junit.Test;
import org.xml.sax.SAXException;

import junit.framework.Assert;

public class OperationsTest {
        @Test public void testOperations() throws IOException, SAXException {
            Message message = new Message();
            message.setText("Hello world");
            
            try(InputStream input = getClass().getClassLoader().getResourceAsStream("encrypt.xml")){
                Digester digester = new Digester();
                digester.addRule("*/email", new EmailRule());
                digester.addRule("*/lower", new LowerRule());
                digester.addRule("*/reverse", new ReverseRule());
                digester.addRule("*/replace", new ReplaceRule());
                digester.push(message);
                digester.parse(input);

                Assert.assertEquals("zlrqw qlleh", message.getText());
            }
        }
}
