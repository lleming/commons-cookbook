package org.example;

import java.net.URL;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.junit.Test;

import junit.framework.Assert;

public class NestedPropertiesConfigurationTest {
    @Test
    public void testNestedPropertiesConfig() throws ConfigurationException {
        ConfigurationFactory factory = new ConfigurationFactory();
        URL configUrl = getClass().getClassLoader().getResource("config/config.xml");

        factory.setConfigurationURL(configUrl);

        Configuration config = factory.getConfiguration();

        Assert.assertEquals("User property speed", 5000, config.getInt("speed"));
        Assert.assertEquals("User property name", "Sean", config.getString("name"));
        Assert.assertEquals("User property color", "black", config.getString("color"));
        Assert.assertEquals("User property threads min", 1, config.getInt("threads.min"));

        Assert.assertEquals("Local property interactive", false, config.getBoolean("interactive"));
        Assert.assertEquals("Local property extel", "c", config.getString("extel"));

        Assert.assertEquals("Global property timeout", 15.52F, config.getFloat("timeout"));
    }
}
