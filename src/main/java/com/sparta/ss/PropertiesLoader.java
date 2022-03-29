package com.sparta.ss;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties(String filename) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}


