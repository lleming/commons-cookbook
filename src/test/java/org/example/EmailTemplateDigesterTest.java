package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Substitutor;
import org.apache.commons.digester.substitution.MultiVariableExpander;
import org.apache.commons.digester.substitution.VariableSubstitutor;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.junit.Test;
import org.xml.sax.SAXException;

import junit.framework.Assert;

public class EmailTemplateDigesterTest {
    @Test
    public void testEmailTemplateFilling() throws IOException, SAXException {
        URL rules = getClass().getClassLoader().getResource("email-rules.xml");
        Digester digester = DigesterLoader.createDigester(rules);

        List emails = new ArrayList();

        digester.push(emails);

        Map vars = new HashMap();

        vars.put("email.to", "aldino.kronnos@sigunda.com");
        vars.put("email.from", "hr@trenches.com");
        vars.put("user.name", "Robert");
        vars.put("order.id", "1RRR#555_683PRM");
        vars.put("product.name", "Foundation");

        MultiVariableExpander expander = new MultiVariableExpander();
        expander.addSource("$", vars);

        Substitutor substitutor = new VariableSubstitutor(expander);
        digester.setSubstitutor(substitutor);

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("email-template.xml")) {
            digester.parse(input);
            Email email = (Email) emails.get(0);
            Email expected = new Email();
            expected.setFrom("hr@trenches.com");
            expected.setTo("aldino.kronnos@sigunda.com");
            expected.setPriority("High");
            expected.setSubject("Purchase Confirmation: 1RRR#555_683PRM");
            expected.setMessage("Dear Robert, we appreciate your bussiness. As CEO\n" +
                    "     of Big Software Company, Inc., I would like to\n" +
                    "personally thank you for helping us become filthy rich.\n" +
                    "Your purchaise of Foundation helped me purchaise an\n" +
                    "even larger boat for myself. Thanks again.\n");
            Assert.assertEquals(expected, email);
        }
    }
}
