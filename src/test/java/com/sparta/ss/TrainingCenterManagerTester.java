package com.sparta.ss;

import com.sparta.ss.trainingcentre.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManagerTester {

    private static TrainingCenterManager trainingCenterManager = new TrainingCenterManager();

    static List<BootcampCenter> bootcampCenters = new ArrayList<>();

    static List<TrainingCenter> trainingCenters = new ArrayList<>();

    static List<TrainingHub> trainingHubs = new ArrayList<>();

    static List<TechCentre> techCentres = new ArrayList<>();

    @BeforeAll
    static void createListCenters() {
        //TrainingCenter trainingCenter1 = new TrainingCenter();
        //TrainingCenter trainingCenter2 = new TrainingCenter();
        //TrainingCenter trainingCenter3 = new TrainingCenter();
        //TrainingCenter trainingCenter4 = new TrainingCenter();

        createTrainingCenter(4);

        createBootcampCentre(4);

        createTechCenter(4);

        createTrainingHub(4);

        trainingCenters.get(1).setOccupiedSeats(100);
        trainingCenters.get(1).setOccupiedSeats(70);
        trainingCenters.get(1).setOccupiedSeats(50);

        bootcampCenters.get(1).setOccupiedSeats(500);
        bootcampCenters.get(1).setOccupiedSeats(70);
        bootcampCenters.get(1).setOccupiedSeats(50);

        trainingHubs.get(1).setOccupiedSeats(100);
        trainingHubs.get(1).setOccupiedSeats(70);
        trainingHubs.get(1).setOccupiedSeats(50);

        techCentres.get(1).setOccupiedSeats(100);
        techCentres.get(1).setOccupiedSeats(70);
        techCentres.get(1).setOccupiedSeats(50);

        //trainingCenter2.setOccupiedSeats(100);
        //trainingCenter2.setOccupiedSeats(70);
        //trainingCenter2.setOccupiedSeats(50);

        //trainingCenterManager.getTrainingCenters().add(trainingCenter1);
        //trainingCenterManager.getTrainingCenters().add(trainingCenter2);
        //trainingCenterManager.getTrainingCenters().add(trainingCenter3);
        //trainingCenterManager.getTrainingCenters().add(trainingCenter4);
    }

    private static void createBootcampCentre(int numberOfCentre) {

        for (int i = 0; i < numberOfCentre; i ++) {
            bootcampCenters.add(new BootcampCenter());
            trainingCenterManager.getBootcampCenters().add(bootcampCenters.get(i));
        }
    }

    private static void createTrainingCenter(int numberOfCentre) {
        for (int i = 0; i < numberOfCentre; i ++) {
            trainingCenters.add(new TrainingCenter());
            trainingCenterManager.getTrainingCenters().add(trainingCenters.get(i));
        }
    }

    private static void createTechCenter(int numberOfCentre) {
        for (int i = 0; i < numberOfCentre; i ++) {
            techCentres.add(new TechCentre());
            trainingCenterManager.getTechCenters().add(techCentres.get(i));
        }
    }

    private static void createTrainingHub(int numberOfCentre) {
        for (int i = 0; i < numberOfCentre; i ++) {
            trainingHubs.add(new TrainingHub());
            trainingCenterManager.getTrainingHub().add(trainingHubs.get(i));
        }
    }

    @Test
    @DisplayName("return number of open centers")
    void returnListOfOpenCenters() {
        int countOpenCenters = trainingCenterManager.getOpenCenters();
        Assertions.assertEquals(3, countOpenCenters);
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
        int countTrainingTrainees = trainingCenterManager.getNumberTraineesInTraining();
        Assertions.assertEquals(220, countTrainingTrainees);
    }

    @Test
    @DisplayName("return number of full bootcamp centers")
    void returnListOfFullBootcampCenters() {
        int countFullCenters = trainingCenterManager.getFullBootCampCount();
        Assertions.assertEquals(1, countFullCenters);
    }

    @Test
    @DisplayName("return number of full training hub")
    void returnListOfFullTrainingHub() {
        int countFullCenters = trainingCenterManager.getFullTrainingHubCount();
        Assertions.assertEquals(1, countFullCenters);
    }

    @Test
    @DisplayName("return number of full tech centers")
    void returnListOfFullTechCenters() {
        int countFullCenters = trainingCenterManager.getFullTechCenterCount();
        Assertions.assertEquals(1, countFullCenters);
    }

    //@Test
    //@DisplayName("return number of open bootcamp centers")
    //void returnListOfOpenBootcampCenters() {
    //    int countOpenCenters = trainingCenterManager.getOpenBootCampCount();
    //    Assertions.assertEquals(3, countOpenCenters);
    //}

    @Test
    @DisplayName("return number of open training hub")
    void returnListOfOpenTrainingHub() {
        int countOpenCenters = trainingCenterManager.getOpenTrainingHubCount();
        Assertions.assertEquals(3, countOpenCenters);
    }

    @Test
    @DisplayName("return number of open tech centers")
    void returnListOfOpenTechCenters() {
        int countOpenCenters = trainingCenterManager.getOpenTechCenterCount();
        Assertions.assertEquals(3, countOpenCenters);
    }

    @Test
    @DisplayName("return number of close bootcamp centers")
    void returnListOfCloseBootcampCentersAfter1Month() {
        for(int i = 0; i < 1; i ++) {
            trainingCenterManager.removeLowAttendanceBootcamp();
        }
        trainingCenterManager.removeLowAttendanceBootcamp();
        int countCloseCenters = trainingCenterManager.getClosedBootcampCentres();
        Assertions.assertEquals(0, countCloseCenters);
    }

    @Test
    @DisplayName("return number of close bootcamp centers")
    void returnListOfCloseBootcampCentersAfter2Month() {
        for(int i = 0; i < 2; i ++) {
            trainingCenterManager.removeLowAttendanceBootcamp();
        }
        int countCloseCenters = trainingCenterManager.getClosedBootcampCentres();
        Assertions.assertEquals(0, countCloseCenters);
    }

    @Test
    @DisplayName("return number of close bootcamp centers")
    void returnListOfCloseBootcampCentersAfter3Month() {
        for(int i = 0; i < 3; i ++) {
            trainingCenterManager.removeLowAttendanceBootcamp();
        }
        int countCloseCenters = trainingCenterManager.getClosedBootcampCentres();
        Assertions.assertEquals(3, countCloseCenters);
    }
//
    @Test
    @DisplayName("return number of close training hub")
    void returnListOfCloseTrainingHub() {
        trainingCenterManager.removeLowAttendanceTrainingHub();
        int countCloseCenters = trainingCenterManager.getClosedTrainingHubs();
        Assertions.assertEquals(3, countCloseCenters);
    }

    @Test
    @DisplayName("return number of close tech centers")
    void returnListOfCloseTechCenters() {
        trainingCenterManager.removeLowAttendanceTechcentre();
        int countCloseCenters = trainingCenterManager.getClosedTechCentres();
        Assertions.assertEquals(3, countCloseCenters);
    }

}
