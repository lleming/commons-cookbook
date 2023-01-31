package org.example.digester;

import org.apache.commons.digester.Rule;
import org.apache.commons.lang.StringUtils;

public class ReverseRule extends Rule {

    @Override
    public void body(String namespace, String name, String text) throws Exception {
        Message message  = (Message) digester.getRoot();
        String content = message.getText();
        message.setText(StringUtils.reverse(content));
    }
}
