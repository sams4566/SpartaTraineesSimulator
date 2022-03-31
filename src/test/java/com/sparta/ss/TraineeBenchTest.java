package com.sparta.ss;

import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeBench;
import com.sparta.ss.trainee.TraineeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraineeBenchTest {

    @Test
    @DisplayName("Check if trainees are added to bench after one year")
    void checkIfTraineesAreAddedToBenchAfterOneYear() {
        Trainee trainee1 = new Trainee();
        trainee1.setTrainingTime(11);
        Trainee trainee2 = new Trainee();
        trainee2.setTrainingTime(11);
        Trainee trainee3 = new Trainee();
        trainee3.setTrainingTime(7);
        TraineeManager.currentlyTrainingTrainees = new ArrayList<>(Arrays.asList(trainee1, trainee2, trainee3));
        TraineeBench.gettingTraineesToBench();
        assertEquals(2, TraineeBench.benchTrainees.size());
    }


    @Test
    @DisplayName("Check if training time is incremented by one after each month")
    void checkIfTrainingTimeIsIncrementedByOneAfterEachMonth() {
        Trainee trainee1 = new Trainee();
        trainee1.setTrainingTime(7);
        TraineeManager.currentlyTrainingTrainees = new ArrayList<>(Arrays.asList(trainee1));
        TraineeBench.gettingTraineesToBench();
        Assertions.assertEquals(8,TraineeManager.currentlyTrainingTrainees.get(0).getTrainingTime());
    }


}
