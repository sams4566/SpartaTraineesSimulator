package com.sparta.ss;

import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;
import com.sparta.ss.trainingcentre.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingCenterManagerTester {

    private static TrainingCenterManager trainingCenterManager = new TrainingCenterManager();

    static List<BootcampCenter> bootcampCenters = new ArrayList<>();


    static List<TrainingHub> trainingHubs = new ArrayList<>();

    static List<TechCentre> techCentres = new ArrayList<>();

    @BeforeAll
    static void createListCenters() {

        createBootcampCentre(2);

        createTechCenter(4);

        createTrainingHub(4);

        bootcampCenters.get(1).setOccupiedSeats(20);
        bootcampCenters.get(1).setOccupiedSeats(500);

        trainingHubs.get(1).setOccupiedSeats(100);
        trainingHubs.get(1).setOccupiedSeats(70);
        trainingHubs.get(1).setOccupiedSeats(50);

        techCentres.get(1).setOccupiedSeats(100);
        techCentres.get(1).setOccupiedSeats(70);
        techCentres.get(1).setOccupiedSeats(50);

    }

    private static void createBootcampCentre(int numberOfCentre) {

        for (int i = 0; i < numberOfCentre; i ++) {
            bootcampCenters.add(new BootcampCenter());
            trainingCenterManager.getBootcampCenters().add(bootcampCenters.get(i));
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
    @DisplayName("return number of trainees in training")
    void returnNumberOfTraineesInTraining() {
        Trainee trainee1 = new Trainee();
        trainee1.setTrainingTime(11);
        Trainee trainee2 = new Trainee();
        trainee2.setTrainingTime(11);
        Trainee trainee3 = new Trainee();
        trainee3.setTrainingTime(7);
        TraineeManager.currentlyTrainingTrainees = new ArrayList<>(Arrays.asList(trainee1, trainee2, trainee3));
        int countTrainingTrainees = TraineeManager.currentlyTrainingTrainees.size();
        Assertions.assertEquals(3, countTrainingTrainees);
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


    @Test
    @DisplayName("return number of open training hub")
    void returnListOfOpenTrainingHub() {
        int countOpenCenters = trainingCenterManager.getOpenTrainingHubCount();
        Assertions.assertEquals(3, countOpenCenters);
    }

    @Test
    @DisplayName("return number of open tech centers")
    void returnListOfOpenTechCenters() {
        int countOpenCenters = trainingCenterManager.getOpenTechCentersCount();
        Assertions.assertEquals(0, countOpenCenters);
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
    void returnListOfCloseBootcampCentersAfter3Month() {
        for(int i = 0; i < 3; i ++) {
            trainingCenterManager.removeLowAttendanceBootcamp();
        }
        int countCloseCenters = trainingCenterManager.getClosedBootcampCentres();
        Assertions.assertEquals(1, countCloseCenters);
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
