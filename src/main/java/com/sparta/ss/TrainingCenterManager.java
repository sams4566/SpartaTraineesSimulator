package com.sparta.ss;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {

    List<TrainingCenter> trainingCenters = new ArrayList<>();


    public List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public int getOpenCenters() {
        return trainingCenters.size();
    }

    public int getFullCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).count();
    }
}
