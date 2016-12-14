package com.epam.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static final Logger LOG = Logger.getLogger(ReadProperties.class);

    public ReadProperties() {
    }

    public static Properties getData(String path) {
        return getDataFromPropertyFile(path);
    }

    private static Properties getDataFromPropertyFile(String path) {
        Properties properties = new Properties();
        try (InputStream file = ReadProperties.class.getResourceAsStream(path)) {
            properties.load(file);
        } catch (IOException e) {
            LOG.warn("Some problem with download properties" + e);
        }
        return properties;
    }
}
