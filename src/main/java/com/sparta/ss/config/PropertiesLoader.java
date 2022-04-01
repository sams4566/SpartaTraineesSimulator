package com.sparta.ss.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}


