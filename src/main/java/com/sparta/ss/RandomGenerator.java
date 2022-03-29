package com.sparta.ss;

import java.util.Random;

public class RandomGenerator {

    public static int getRandom() {
        Random random = new Random();
        int numberTrainees = random.nextInt(101 - 50) + 50;
        return numberTrainees;
    }

    public  static int getNumberOfTraineesForCenter(){
        Random random = new Random();
        int numberTrainees = random.nextInt(51);
        return numberTrainees;
    }
}
