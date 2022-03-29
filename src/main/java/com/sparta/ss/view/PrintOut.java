package com.sparta.ss.view;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;

public class PrintOut {

    public static void printOut(){
        System.out.println("The program is going to simulate " + PropertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfYears")+ " years.");
        System.out.println("The program is going to generate " + PropertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfCentresGeneratedEveryOtherMonth")+ " every other month.");
        System.out.println("The program is run " + PropertiesLoader.getProperties(ConfigFilename.filename).getProperty("amountOfTimesToRun")+ " times.");
    }
}
