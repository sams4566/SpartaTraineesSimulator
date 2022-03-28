package com.sparta.ss;

import com.sparta.ss.view.PrintOut;

public class MonthIterator {

    public void monthIterator(){
        PrintOut.printOut();
        for(int i = 0; i < getProperty("amountOfTimesToRun"); i++){
            for(int j = 1; j <= getProperty("amountOfYears")*12; j++){
                if(j%2 == 1){
                    TrainingCenter trainingCenter = new TrainingCenter(100,0);
                }
            }
        }

    }

    private int getProperty(String property){
        return Integer.parseInt(PropertiesLoader.getProperties().getProperty(property));
    }

}
