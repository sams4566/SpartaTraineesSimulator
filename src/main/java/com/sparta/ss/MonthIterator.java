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
import com.sparta.ss.trainingcentre.*;
import com.sparta.ss.trainingcentre.TechCentre;
import com.sparta.ss.trainingcentre.TrainingCenter;
import com.sparta.ss.trainingcentre.TrainingCenterManager;



import java.util.ArrayList;
import java.util.List;

public class MonthIterator {

    public static void monthIterator(String filename) {

        List<String[]> recordPerYearList = new ArrayList<>();
        List<String[]> recordPerMonthList = new ArrayList<>();

        try {
            SpartaSimulatorLogger.InfoMessage("Getting number of runs");
            for (int i = 0; i < CheckConfig.checkNumberOfRuns(filename); i++) {
                TraineeManager.getTrainees().clear();
                TrainingCenterManager.removeAllTrainingCenter();
                TraineeManager.removeAllTraineesFromWaitingList();
                SpartaSimulatorLogger.InfoMessage("Getting number of years");
                for (int j = 1; j <= CheckConfig.checkNumberOfYears(filename) * 12; j++) {
                    if (j % 2 != 1) {
                        SpartaSimulatorLogger.InfoMessage("Generating training center");
                        generateTrainingCenter();

                    }
                    traineeAllocator();
                    TrainingCenterManager.removeLowAttendanceBootcamp();
                    TrainingCenterManager.removeLowAttendanceTrainingHub();
                    TrainingCenterManager.removeLowAttendanceTechcentre();
                    String records[] = {String.valueOf(i + 1), String.valueOf(j), String.valueOf(TrainingCenterManager.getOpenCenters()), String.valueOf(TrainingCenterManager.getFullCenters()), String.valueOf(TrainingCenterManager.getNumberTraineesInTraining()), String.valueOf(TraineeManager.getWaitingList().size())};
                    recordPerMonthList.add(records);

                }
                String records[] = {String.valueOf(i + 1), String.valueOf(TrainingCenterManager.getOpenCenters()), String.valueOf(TrainingCenterManager.getFullCenters()), String.valueOf(TrainingCenterManager.getNumberTraineesInTraining()), String.valueOf(TraineeManager.getWaitingList().size())};
                recordPerYearList.add(records);
            }
            SpartaSimulatorLogger.InfoMessage("Creating CSV file");

            if (CheckConfig.checkChoiceOfOutput(filename).equalsIgnoreCase("year")) {
                ConvertCSVFile.createYearCVSFile(recordPerYearList);
            } else if (CheckConfig.checkChoiceOfOutput(filename).equalsIgnoreCase("month")) {
                ConvertCSVFile.createMonthCVSFile(recordPerMonthList);
            }
            SpartaSimulatorLogger.InfoMessage("CSV file ready");

        } catch (InvalidYearException e) {
            SpartaSimulatorLogger.warningMessage("Invalid year exception thrown");
            System.out.println(e.getMessage());
        } catch (InvalidRunNumberException e) {
            SpartaSimulatorLogger.warningMessage("Invalid run number exception thrown");
            System.out.println(e.getMessage());
        } catch (InvalidChoiceOfOutput e) {
            SpartaSimulatorLogger.warningMessage("Invalid choice of output exception thrown");
            System.out.println(e.getMessage());
        }
    }

    private static void generateTrainingCenter() {
        String typeOfTrainingCenter = RandomGenerator.getRandomTrainingCenter();
        int numberOfCentersGenerated =0;
        if(typeOfTrainingCenter.equals("TrainingHub")){
            numberOfCentersGenerated = 3;
        }else {
            numberOfCentersGenerated = 1;
        }
        for (int t = 0; t < numberOfCentersGenerated; t++) {
            switch (typeOfTrainingCenter){
                case "TrainingHub":
                    TrainingHub trainingHub = new TrainingHub();
                    TrainingCenterManager.getTrainingHub().add(trainingHub);
                    break;
                case "BootCamp":
                    if(TrainingCenterManager.getBootcampCenters().size() == BootcampCenter.getMaxBootcamp()){
                        generateTrainingCenter();
                    }else{
                        BootcampCenter bootcampCenter = new BootcampCenter();
                        TrainingCenterManager.getBootcampCenters().add(bootcampCenter);
                    }
                    break;
                case "TechCenter":
                    TechCentre techCentre = new TechCentre();
                    TrainingCenterManager.getTechCenters().add(techCentre);
                    break;
                default:
                    break;
            }
        }
    }


    public static void traineeAllocator() {
        SpartaSimulatorLogger.InfoMessage("Updating the waiting list");
        int numberOfTrainees = RandomGenerator.getRandomTrainees();
        addToNewTraineesList(numberOfTrainees);
        if (TrainingCenterManager.getOpenCenters() == 0) {
            addToWaitingList(numberOfTrainees);
        } else {
            TrainingCenter.allocateTrainees();
        }

    }


    private static void addToNewTraineesList(int numberOfTrainees) {
        while (numberOfTrainees != 0) {
            TraineeManager.getTrainees().add(new Trainee());
            numberOfTrainees--;
        }

    }
//        return numberOfTrainees;


    private static void addToWaitingList(int numberOfTrainees) {
        while (numberOfTrainees != 0) {
            TraineeManager.getWaitingList().add(new Trainee());
            numberOfTrainees--;
        }
    }

    private int getProperty(String property) {
        return Integer.parseInt(PropertiesLoader.getProperties(ConfigFilename.filename).getProperty(property));
    }

}
