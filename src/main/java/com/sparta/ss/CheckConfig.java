package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;

public class CheckConfig {
    static  PropertiesLoader propertiesLoader = new PropertiesLoader();

    public static int checkNumberOfYears() throws InvalidYearException {
        int year = Integer.parseInt(propertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfYears"));
        return year;
    }

    public static int OfCentersGenerated() throws InvalidCenterNumberException {
            int numberOfCenters = Integer.parseInt(propertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfCentresGeneratedEveryOtherMonth"));
            return numberOfCenters;
    }


    public static int checkNumberOfRuns() throws InvalidRunNumberException {
        int numberOfRuns = Integer.parseInt(propertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfTimesToRun"));
        return numberOfRuns;
    }
}
