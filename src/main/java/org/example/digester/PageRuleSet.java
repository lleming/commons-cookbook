package org.example.digester;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

public class PageRuleSet extends RuleSetBase {

    public PageRuleSet() {
        this.namespaceURI = "http://discursive.com/person";
    }

    @Override
    public void addRuleInstances(Digester digester) {
        digester.addObjectCreate("*/page", Page.class);
        digester.addSetNext("*/page", "addPage");
        digester.addSetProperties("*/page");
        digester.addBeanPropertySetter("*/page/summary", "summary");

    }

}
