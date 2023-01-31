package org.example;

import java.net.URL;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

import junit.framework.Assert;

public class XmlConfigurationTest {
    @Test public void testXmlConfiguration() throws ConfigurationException {
        URL resource = getClass().getClassLoader().getResource("config.xml");
        Configuration config = new XMLConfiguration(resource);
        List startCriterias = config.getList("start-criteria.criteria");
        Assert.assertEquals(2, startCriterias.size());
        String firstCriterial = config.getString("start-criteria.criteria(0)");
        String firstCriteriaType = config.getString("start-criteria.criteria(0)[@type]");
        int horsepower = config.getInt("horsepower");
        Assert.assertEquals("Temperature above -10 Celsius", firstCriterial);
        Assert.assertEquals("critical", firstCriteriaType);
        Assert.assertEquals(42      , horsepower);
    }
}
