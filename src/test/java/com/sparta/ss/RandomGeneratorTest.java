package com.sparta.ss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.ss.RandomGenerator.getRandom;

public class RandomGeneratorTest {
    @Test
    @DisplayName("Min 10 Max 20 returns int between 10 and 20")
    void min10Max20ReturnsIntBetween10And20() {
        int value = getRandom();
        System.out.println(value);
        Assertions.assertTrue(value<= 100 && value >= 50);
    }
}
