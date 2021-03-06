package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sparta.ss.utilities.RandomGenerator.*;

public class RandomGeneratorTest {
    @Test
    @DisplayName("getRandomTrainees returns value between 50 and 100")
    void getRandomTraineesReturnsValueBetween50And100() {
        for (int i = 0; i < 19 ; i++){
            int value = getRandomTrainees();
            Assertions.assertTrue(value <= 100 && value >= 50);
        }
    }

    @Test
    @DisplayName("getNumberOfTraineesForCenter returns value between 0 and 50")
    void getNumberOfTraineesForCenterReturnsValueBetween50And100() {
        for (int i = 0; i < 19; i++) {
            int value = getNumberOfTraineesForCenter();
            Assertions.assertTrue(value <= 50 && value >= 0);
        }
    }

    @Test
    @DisplayName("getRandomCourse returns 5 job streams at random")
    void getRandomCourseReturns5JobStreamsAtRandom() {
        for (int i = 0; i < 19; i++) {
            String value = getRandomCourse();
            ArrayList<String> courses = new ArrayList<>(Arrays.asList("Java", "C#", "Data", "DevOps", "Business"));
            Assertions.assertEquals(true, courses.contains(value));
        }
    }
}
