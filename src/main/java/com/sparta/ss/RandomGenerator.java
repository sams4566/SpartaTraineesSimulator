package com.sparta.ss;

import java.util.Random;

public class RandomGenerator {

    public int getRandom (int minimum, int maximum) {

        int min = minimum;
        int max = maximum;
        Random random = new Random();
        int numberTrainees = random.nextInt(max - min) + min;
        return numberTrainees;
    }
}
