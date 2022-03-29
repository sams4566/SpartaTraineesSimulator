package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCenterManagerTester {

    private static TrainingCenterManager trainingCenterManager = new TrainingCenterManager();

    @BeforeAll
    static void createListCenters() {
        TrainingCenter trainingCenter1 = new TrainingCenter(100,100);
        TrainingCenter trainingCenter2 = new TrainingCenter(100,100);
        TrainingCenter trainingCenter3 = new TrainingCenter(100,100);
        TrainingCenter trainingCenter4 = new TrainingCenter(100,0);
        trainingCenterManager.getTrainingCenters().add(trainingCenter1);
        trainingCenterManager.getTrainingCenters().add(trainingCenter2);
        trainingCenterManager.getTrainingCenters().add(trainingCenter3);
        trainingCenterManager.getTrainingCenters().add(trainingCenter4);

    }

    @Test
    @DisplayName("return list of open centers")
    void returnListOfOpenCenters() {
        int countCenters = trainingCenterManager.getOpenCenters();
        Assertions.assertEquals(4, countCenters);
    }

    @Test
    @DisplayName("return list of full centers")
    void returnListOfFullCenters() {
        int countFullCenters = trainingCenterManager.getFullCenters();
        Assertions.assertEquals(3, countFullCenters);
    }


}
