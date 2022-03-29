package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.exception.InvalidCenterNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckConfigTest {
    @Test
    @DisplayName("Check number of center number")
    void checkNumberOfCenterNumber() {
        Throwable exception = Assertions.assertThrows(NumberFormatException.class, () -> MonthIterator.monthIterator(ConfigFilename.testConfigExceptionsFilename));
        Assertions.assertEquals("aa", exception.getMessage());
    }
}
