package com.sparta.ss;

import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidChoiceOfOutput;
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

    public static String checkChoiceOfOutput(String filename) throws InvalidChoiceOfOutput {
        String choiceOfOutput = null;
        try {
            choiceOfOutput= propertiesLoader.getProperties(filename).getProperty("choiceOfOutput");
            if (!choiceOfOutput.toLowerCase().equals("year") && !choiceOfOutput.toLowerCase().equals("month")) {
                throw new InvalidChoiceOfOutput();
            }
        }catch (Exception e){
            throw new InvalidChoiceOfOutput();
        }
        return choiceOfOutput;
    }
}
