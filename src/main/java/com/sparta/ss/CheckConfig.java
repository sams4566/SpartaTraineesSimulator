package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;

public class CheckConfig {
    static  PropertiesLoader propertiesLoader = new PropertiesLoader();

    public static int checkNumberOfYears(String filename) throws InvalidYearException {
        int year = 0;
            try {
                year = Integer.parseInt(propertiesLoader.getProperties(filename).getProperty("amountOfYears"));
                if (year <= 0) {
                    throw new InvalidYearException();
                }
            }catch (Exception e){
                throw new InvalidYearException();
        }
            return year;
    }

    public static int checkNumberOfCentersGenerated(String filename) throws InvalidCenterNumberException {
        int numberOfCenters = 0;
        try {
            numberOfCenters = Integer.parseInt(propertiesLoader.getProperties(filename).getProperty("amountOfCentresGeneratedEveryOtherMonth"));
            if (numberOfCenters <= 0) {
                throw new InvalidCenterNumberException();
            }
        }catch (Exception e){
            throw new InvalidCenterNumberException();
        }
        return numberOfCenters;
    }


    public static int checkNumberOfRuns(String filename) throws InvalidRunNumberException {
        int numberOfRuns = 0;
        try {
            numberOfRuns= Integer.parseInt(propertiesLoader.getProperties(filename).getProperty("amountOfTimesToRun"));
            if (numberOfRuns <= 0) {
                throw new InvalidRunNumberException();
            }
        }catch (Exception e){
            throw new InvalidRunNumberException();
        }
        return numberOfRuns;
    }
}
