package com.sparta.ss;

import java.util.Random;

public class RandomGenerator {

    public int getRandom() {
        Random random = new Random();
        int numberTrainees = random.nextInt(101 - 50) + 50;
        return numberTrainees;
    }
}
