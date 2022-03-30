package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.exception.InvalidCenterNumberException;
import com.sparta.ss.exception.InvalidChoiceOfOutput;
import com.sparta.ss.exception.InvalidRunNumberException;
import com.sparta.ss.exception.InvalidYearException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckConfigTest {
    @Test
    @DisplayName("Check number of years")
    void checkNumberOfYears() {
        try {
            assertEquals(1, CheckConfig.checkNumberOfYears(ConfigFilename.testConfigExceptionsFilename));
        } catch (InvalidYearException e) {
            assertEquals("Number of years is wrong ! Please try again", e.getMessage());
        }
    }

    @Test
    @DisplayName("Check number of training centers in every two months")
    void checkNumberOfTrainingCentersInEveryTwoMonths() {
        try {
            assertEquals(1, CheckConfig.checkNumberOfCentersGenerated(ConfigFilename.testConfigExceptionsFilename));
        } catch (InvalidCenterNumberException e) {
            assertEquals("Number of centers to be generated in every two months is wrong ! Please try again", e.getMessage());
        }
    }

    @Test
    @DisplayName("Check number of runs")
    void checkNumberOfRuns() {
        try {
            assertEquals(1, CheckConfig.checkNumberOfRuns(ConfigFilename.testConfigExceptionsFilename));
        } catch (InvalidRunNumberException e) {
            assertEquals("Number of runs is wrong ! Please try again", e.getMessage());
        }
    }

    @Test
    @DisplayName("Check number of runs")
    void checkChoiceOfInput() {
        try {
            assertEquals(1, CheckConfig.checkChoiceOfOutput(ConfigFilename.testConfigExceptionsFilename));
        } catch (InvalidChoiceOfOutput e) {
            assertEquals("The choice of output entered is wrong ! Please try again !", e.getMessage());
        }
    }

}
