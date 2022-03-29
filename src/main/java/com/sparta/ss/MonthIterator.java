package com.sparta.ss;

import com.sparta.ss.view.PrintOut;

public class MonthIterator {

    int waitingList = 0;

    public void monthIterator(){
        PrintOut.printOut();
        for(int i = 0; i < getProperty("amountOfTimesToRun"); i++){
            for(int j = 1; j <= getProperty("amountOfYears")*12; j++){
                int numberofTrainees = RandomGenerator.getRandom();
                if(j%2 != 1){
                    for(int t = 0; t < getProperty("amountOfCentresGeneratedEveryOtherMonth");t++){
                        TrainingCenter trainingCenter = new TrainingCenter();
                    }
                }
                if(TrainingCenter.openTrainingCenter.size()==0){
                    waitingList+= numberofTrainees;
                }
                //else
            }
        }

    }

    private int getProperty(String property){
        return Integer.parseInt(PropertiesLoader.getProperties().getProperty(property));
    }

}
