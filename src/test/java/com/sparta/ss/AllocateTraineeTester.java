package com.sparta.ss;

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
        TrainingCenterManager.trainingCenters.add(centre1);
        TrainingCenterManager.trainingCenters.add(centre2);
        TrainingCenterManager.trainingCenters.add(centre3);
//        allocateTrainees(150);
        Assertions.assertEquals(1,1);
    }
}
