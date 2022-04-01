package com.sparta.ss.view;

import com.sparta.ss.config.PropertiesLoader;

public class PrintOut {

    public static void printOut(){
        System.out.println("The program is going to simulate " + PropertiesLoader.getProperties().getProperty("amountOfYears")+ " years.");
        System.out.println("The program is going to generate " + PropertiesLoader.getProperties().getProperty("amountOfCentresGeneratedEveryOtherMonth")+ " every other month.");
        System.out.println("The program is run " + PropertiesLoader.getProperties().getProperty("amountOfTimesToRun")+ " times.");
    }
}
