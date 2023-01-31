package org.example.digester;

import org.apache.commons.digester.Rule;
import org.apache.commons.lang.StringUtils;

public class LowerRule extends Rule {

    @Override
    public void body(String namespace, String name, String text) throws Exception {
        Message message = (Message) digester.getRoot();
        String lower = StringUtils.lowerCase(message.getText());
        message.setText(lower);
    }
}
