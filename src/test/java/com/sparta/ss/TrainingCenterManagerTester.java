package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCenterManagerTester {

    private static TrainingCenterManager trainingCenterManager = new TrainingCenterManager();

    @BeforeAll
    static void createListCenters() {
        TrainingCenter trainingCenter1 = new TrainingCenter();
        TrainingCenter trainingCenter2 = new TrainingCenter();
        TrainingCenter trainingCenter3 = new TrainingCenter();
        TrainingCenter trainingCenter4 = new TrainingCenter();
        trainingCenter2.setVacancySeats(0);
        trainingCenter3.setVacancySeats(30);
        trainingCenter4.setVacancySeats(50);
        trainingCenterManager.getTrainingCenters().add(trainingCenter1);
        trainingCenterManager.getTrainingCenters().add(trainingCenter2);
        trainingCenterManager.getTrainingCenters().add(trainingCenter3);
        trainingCenterManager.getTrainingCenters().add(trainingCenter4);
    }

    @Test
    @DisplayName("return number of open centers")
    void returnListOfOpenCenters() {
        int countCenters = trainingCenterManager.getOpenCenters();
        Assertions.assertEquals(3, countCenters);
    }

    @Test
    @DisplayName("return number of full centers")
    void returnListOfFullCenters() {
        int countFullCenters = trainingCenterManager.getFullCenters();
        Assertions.assertEquals(1, countFullCenters);
    }

    @Test
    @DisplayName("return number of trainees in training")
    void returnNumberOfTraineesInTraining() {
        int countFullCenters = trainingCenterManager.getNumberTraineesInTraining();
        Assertions.assertEquals(220, countFullCenters);
    }
}
