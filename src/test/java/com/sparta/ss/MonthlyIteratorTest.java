package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.trainee.TraineeManager;
import com.sparta.ss.trainingcentre.TrainingCenterManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyIteratorTest {

    @BeforeAll
    static void createListCenters() {
        MonthIterator.monthIterator(ConfigFilename.filename);
    }

    @Test
    @DisplayName("Check waiting list is updated")
    void checkWaitingListIsUpdated() {
        assertEquals(true, TraineeManager.getWaitingList().size()!=0);
    }

    @Test
    @DisplayName("check centres are generated")
    void checkCentresAreGenerated() {
        assertEquals(6, TrainingCenterManager.getTotCenters());
    }


}
