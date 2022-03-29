package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MonthlyIteratorTest {
    @Test
    @DisplayName("Check waiting list is updated")
    void checkWaitingListIsUpdated() {
        MonthIterator.traineeAllocator();
        Assertions.assertEquals(true,MonthIterator.getWaitingList()>=50 && MonthIterator.getWaitingList()<=100);
    }

}
