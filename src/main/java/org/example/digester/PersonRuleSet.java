package org.example.digester;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

public class PersonRuleSet extends RuleSetBase {

    public PersonRuleSet() {
        this.namespaceURI = "http://discursive.com/person";
    }

    @Override
    public void addRuleInstances(Digester digester) {
        digester.addObjectCreate("*/person", Person.class);
        digester.addSetNext("*/person", "addPerson");
        digester.addSetProperties("*/person");
        digester.addBeanPropertySetter("*/person/role", "role");
    }

}
