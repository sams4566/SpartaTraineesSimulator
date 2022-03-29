package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.net.ssl.X509KeyManager;
import java.util.HashMap;
import java.util.Map;

public class ConfigTest {
    @Test
    @DisplayName("Check number of years")
    void checkNumberOfYears() {
        Map<String, Integer> propertyMapper = Map.of("amountOfYears",1,"amountOfCentresGeneratedEveryOtherMonth",1,"amountOfTimesToRun",1);
        for(Map.Entry<String, Integer> entry : propertyMapper.entrySet()){
            Assertions.assertEquals(entry.getValue(), Integer.parseInt(PropertiesLoader.getProperties(ConfigFilename.testFilename).getProperty(entry.getKey())));
        }

    }
}
