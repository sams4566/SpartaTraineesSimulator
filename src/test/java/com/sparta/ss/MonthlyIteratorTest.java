package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyIteratorTest {

    @BeforeAll
    static void createListCenters() {
        MonthIterator.monthIterator();
    }

    @Test
    @DisplayName("Check waiting list is updated")
    void checkWaitingListIsUpdated() {
        assertEquals(true,MonthIterator.getWaitingList()!=0);
    }

    @Test
    @DisplayName("check centres are generated")
    void checkCentresAreGenerated() {
        assertEquals(6,TrainingCenterManager.getTotCenters());
    }

    @Test
    @DisplayName("check centres are filled")
    void checkCentresAreFilled() {
        assertEquals(true,TrainingCenterManager.getFullCenters() >= 1);
    }

    @Test
    @DisplayName("check waiting list is not a negative number")
    void checkWaitingListIsNotANegativeNumber() {
        int i = 0;
        while(i<250){
            MonthIterator.monthIterator();
            Assertions.assertEquals(true,MonthIterator.getWaitingList()>=0);
            i++;
        }

    }
}
