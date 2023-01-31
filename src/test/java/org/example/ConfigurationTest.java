package org.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;

import junit.framework.Assert;

public class ConfigurationTest {

    @Test
    public void testPropertiesConfig() throws ConfigurationException {
        Configuration configuration = new PropertiesConfiguration("test.properties");
        float speed = configuration.getFloat("speed");
        List names = configuration.getList("names");
        boolean correct = configuration.getBoolean("correct");
        float expectedSpeed = 14.44F;
        Assert.assertEquals(expectedSpeed, speed);
        List expectedList = new ArrayList();
        expectedList.add("one");
        expectedList.add("tre");
        expectedList.add("uno");
        Assert.assertEquals(expectedList, names);
        Assert.assertTrue(correct);
    }
}
