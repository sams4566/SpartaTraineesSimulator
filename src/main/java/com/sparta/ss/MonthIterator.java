package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;
import com.sparta.ss.logs.SpartaSimulatorLogger;


public class MonthIterator {

    private static int waitingList = 0;

    public static int getWaitingList() {
        return waitingList;
    }


    public static void monthIterator(String filename) {
 
        try {
            SpartaSimulatorLogger.InfoMessage("Getting number of runs");
            for (int i = 0; i < CheckConfig.checkNumberOfRuns(filename); i++) {
                SpartaSimulatorLogger.InfoMessage("Getting number of years");
                for (int j = 1; j <= CheckConfig.checkNumberOfYears(filename) * 12; j++) {
                    if (j % 2 != 1) {
                        SpartaSimulatorLogger.InfoMessage("Generating training center");
                        for (int t = 0; t < CheckConfig.checkNumberOfCentersGenerated(filename); t++) {
                            TrainingCenter trainingCenter = new TrainingCenter();
                            TrainingCenterManager.getTrainingCenters().add(trainingCenter);
                        }
                    }
                    traineeAllocator();
                }
            }
            ConvertCSVFile.createCVSFile(TrainingCenterManager.getOpenCenters(), TrainingCenterManager.getFullCenters(), TrainingCenterManager.getNumberTraineesInTraining(), waitingList);


        } catch (InvalidYearException e) {
            SpartaSimulatorLogger.warningMessage("Invalid year exception thrown");
            System.out.println(e.invalidYearException());
        } catch (InvalidRunNumberException e) {
            SpartaSimulatorLogger.warningMessage("Invalid run number exception thrown");
            System.out.println(e.invalidRunNumberException());
        } catch (InvalidCenterNumberException e) {
            SpartaSimulatorLogger.warningMessage("Invalid center number exception thrown");
            e.getMessage();
        }
    }


        public static void traineeAllocator () {
            SpartaSimulatorLogger.InfoMessage("Updating the waiting list");
            int numberOfTrainees = RandomGenerator.getRandomTrainees();

            if (TrainingCenterManager.getOpenCenters() == 0) {
                waitingList += numberOfTrainees;
            } else {
                waitingList = TrainingCenter.allocateTrainees(waitingList, numberOfTrainees);
            }
        }

        private int getProperty (String property){
            return Integer.parseInt(PropertiesLoader.getProperties(ConfigFilename.filename).getProperty(property));
        }

}
