package org.example.digester;

import org.apache.commons.digester.Rule;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

public class ReplaceRule extends Rule {

    @Override
    public void begin(Attributes attributes) throws Exception {
        Message message = (Message) digester.getRoot();
        String repl = attributes.getValue("search");
        String with = attributes.getValue("replace");
        message.setText(StringUtils.replace(message.getText(), repl, with));
    }
}
