package com.sparta.ss;

import java.util.Arrays;

public class CheckConfig {

    public static void main(String[] args) {
        String[] configValue = new String[3];
        configValue[0] = PropertiesLoader.getProperties().getProperty("amountOfYears");
        configValue[1] = PropertiesLoader.getProperties().getProperty("amountOfCentresGeneratedEveryOtherMonth");
        configValue[2] = PropertiesLoader.getProperties().getProperty("amountOfTimesToRun");

        try{
            int[] input = new int[3];
            for (int i = 0; i < input.length; i ++) {
                input[i] = Integer.parseInt(configValue[i]);
            }

            System.out.println(Arrays.toString(input));
        }
        catch (NumberFormatException ex){
            System.out.println("The value of config is invalid. Please check config.properties file");
        }
    }
}
