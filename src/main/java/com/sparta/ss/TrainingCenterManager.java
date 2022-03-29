package com.sparta.ss;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {

    static List<TrainingCenter> trainingCenters = new ArrayList<>();

    public List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public static int getOpenCenters() {
        return trainingCenters.size();
    }

    public static int getFullCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).count();
    }

    public static int getEmptyCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).count();
    }

    public static List<TrainingCenter> getEmptyCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).toList();
    }

    public static List<TrainingCenter> getFullCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).toList();
    }

}
