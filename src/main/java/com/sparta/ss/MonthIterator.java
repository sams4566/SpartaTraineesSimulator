package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;
import com.sparta.ss.view.PrintOut;

public class MonthIterator {

    private static int waitingList = 0;

    public static int getWaitingList() {
        return waitingList;
    }

    public void monthIterator() {
        PrintOut.printOut();
        try {

        for(int i = 0; i < getProperty("amountOfTimesToRun"); i++){
            for(int j = 1; j <= getProperty("amountOfYears")*12; j++){
                if(j%2 != 1){
                    for(int t = 0; t < getProperty("amountOfCentresGeneratedEveryOtherMonth");t++){
                        TrainingCenter trainingCenter = new TrainingCenter();
                        TrainingCenterManager.getTrainingCenters().add(trainingCenter);
                    }
                    traineeAllocator();
                }
            }
        }catch (InvalidYearException e){
            System.out.println(e.invalidYearException());
        } catch (InvalidRunNumberException e) {
            System.out.println(e.invalidRunNumberException());
        } catch (InvalidCenterNumberException e) {
            System.out.println(e.invalidCenterNumberException());
        }

    }

    public static void traineeAllocator() {
        int numberofTrainees = RandomGenerator.getRandomTrainees();

        if(TrainingCenterManager.getEmptyCenters()==0){
            waitingList += numberOfTrainees;
        }else{
            waitingList = TrainingCenter.allocateTrainees(waitingList, numberOfTrainees);
        }
    }

    private int getProperty(String property){
        return Integer.parseInt(PropertiesLoader.getProperties(ConfigFilename.filename).getProperty(property));
    }

}
