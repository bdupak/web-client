package com.epam.reader;

import java.util.Properties;

public class ReadValue {
    private static Properties properties =
            ReadProperties.getData("/message.properties");

    public static String getMessage(String messageName){
        return properties.getProperty(messageName);
    }
    public static String getValue(String valueName){
        return properties.getProperty(valueName);
    }
}
