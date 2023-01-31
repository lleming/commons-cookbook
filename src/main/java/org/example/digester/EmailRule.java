package org.example.digester;

import org.apache.commons.digester.Rule;
import org.apache.commons.digester.RuleSet;
import org.xml.sax.Attributes;

public class EmailRule extends Rule {

    private String to;
    private String from;

    @Override
    public void begin(Attributes attributes) throws Exception {
        to = attributes.getValue("to");
        from = attributes.getValue("from");
    }

    @Override
    public void end() throws Exception {
        Message message = (Message) digester.getRoot();
        System.out.println("Email ready to send with message: + " + message.toString());
    }
}
