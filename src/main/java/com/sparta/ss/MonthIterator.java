package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.config.PropertiesLoader;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidChoiceOfOutput;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;
import com.sparta.ss.trainingcentre.TrainingCenter;
import com.sparta.ss.trainingcentre.TrainingCenterManager;


import java.util.ArrayList;
import java.util.List;

public class MonthIterator {

    public static void monthIterator(String filename) {

        List<String[]> recordList = new ArrayList<>();

        try {
            SpartaSimulatorLogger.InfoMessage("Getting number of runs");
            for (int i = 0; i < CheckConfig.checkNumberOfRuns(filename); i++) {
                TraineeManager.getTrainees().clear();
                TraineeManager.getWaitingList().clear();
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
                    String records[] = {String.valueOf(i + 1), String.valueOf(j), String.valueOf(TrainingCenterManager.getOpenCenters()), String.valueOf(TrainingCenterManager.getFullCenters()), String.valueOf(TrainingCenterManager.getNumberTraineesInTraining()), String.valueOf(TraineeManager.getWaitingList().size())};
                    recordList.add(records);
                    if (CheckConfig.checkChoiceOfOutput(filename).toLowerCase().equals("month")) {
                        ConvertCSVFile.createCVSFile(recordList);
                    }

                }

                SpartaSimulatorLogger.InfoMessage("Creating CSV file");
                ConvertCSVFile.createCVSFile(recordList);
                SpartaSimulatorLogger.InfoMessage("CSV file ready");


                if (CheckConfig.checkChoiceOfOutput(filename).toLowerCase().equals("year")) {
                    ConvertCSVFile.createCVSFile(recordList);
                }
            }


            } catch(InvalidYearException e){
                SpartaSimulatorLogger.warningMessage("Invalid year exception thrown");
                System.out.println(e.getMessage());
            } catch(InvalidRunNumberException e){
                SpartaSimulatorLogger.warningMessage("Invalid run number exception thrown");
                System.out.println(e.getMessage());
            } catch(InvalidCenterNumberException e){
                SpartaSimulatorLogger.warningMessage("Invalid center number exception thrown");
                System.out.println(e.getMessage());
            } catch(InvalidChoiceOfOutput e){
                SpartaSimulatorLogger.warningMessage("Invalid choice of output exception thrown");
                System.out.println(e.getMessage());
            }
        }


        public static void traineeAllocator () {
            SpartaSimulatorLogger.InfoMessage("Updating the waiting list");
            int numberOfTrainees = RandomGenerator.getRandomTrainees();
            numberOfTrainees = addToNewTraineesList(numberOfTrainees);
            if (TrainingCenterManager.getOpenCenters() == 0) {
                addToWaitingList(numberOfTrainees);
            } else {
                TrainingCenter.allocateTrainees();
            }
        }

        private static int addToNewTraineesList ( int numberOfTrainees){
            while (numberOfTrainees != 0) {
                TraineeManager.getTrainees().add(new Trainee());
                numberOfTrainees--;
            }
            return numberOfTrainees;
        }

        private static void addToWaitingList ( int numberOfTrainees){
            while (numberOfTrainees != 0) {
                TraineeManager.getWaitingList().add(new Trainee());
                numberOfTrainees--;
            }
        }

        private int getProperty (String property){
            return Integer.parseInt(PropertiesLoader.getProperties(ConfigFilename.filename).getProperty(property));
        }
    }

