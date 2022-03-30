package com.sparta.ss.trainingcentre;

import com.sparta.ss.trainingcentre.TrainingCenter;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {

    public static List<TrainingCenter> trainingCenters = new ArrayList<>();

    public static List<TrainingHub> trainingHubs = new ArrayList<>();

    public static void removeAllTrainingCenter(){
         trainingCenters.removeAll(trainingCenters);
    }

    public static List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public static int getTotCenters() {
        return trainingCenters.size();
    }

    public static List<TrainingHub> getTrainingHub() {
        return trainingHubs;
    }

    public static int getFullCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).count();
    }

    public static int getOpenCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).count();
    }

    public static int getNumberTraineesInTraining(){
        int countTrainees = 0;
        for(TrainingCenter trainingCenter : trainingCenters){
            countTrainees += trainingCenter.getOccupiedSeats();
        }
        return countTrainees;
    }

    public static List<TrainingCenter> getEmptyCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).toList();
    }

    public static List<TrainingCenter> getFullCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).toList();
    }

}
