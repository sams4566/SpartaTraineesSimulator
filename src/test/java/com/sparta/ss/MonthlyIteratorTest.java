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

    @Test
    @DisplayName("check centres are filled")
    void checkCentresAreFilled() {
        assertEquals(true,TrainingCenterManager.getFullCenters() >= 1);
    }
//
//    @Test
//    @DisplayName("check waiting list is not a negative number")
//    void checkWaitingListIsNotANegativeNumber() {
//        int i = 0;
//        while(i<250){
//            MonthIterator.monthIterator(ConfigFilename.filename);
//            Assertions.assertEquals(true,MonthIterator.getWaitingList()>=0);
//            i++;
//        }
//
//    }
}
