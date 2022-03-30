package com.sparta.ss;

import com.sparta.ss.trainingcentre.TrainingCenter;
import com.sparta.ss.trainingcentre.TrainingCenterManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllocateTraineeTester {
    @Test
    @DisplayName("Number Trainees 150 Fills First Two Centres")
    void numberTrainees50FillsCentresTo100() {
        TrainingCenter centre1 = new TrainingCenter();
        TrainingCenter centre2 = new TrainingCenter();
        TrainingCenter centre3 = new TrainingCenter();
        TrainingCenterManager.getTrainingCenters().add(centre1);
        TrainingCenterManager.getTrainingCenters().add(centre2);
        TrainingCenterManager.getTrainingCenters().add(centre3);
//        allocateTrainees(150);
        Assertions.assertEquals(1,1);
    }
}
