package com.sparta.ss;

import java.util.Random;

public class RandomGenerator {

    public static int getRandomTrainees() {
        Random random = new Random();
        int numberTrainees = random.nextInt(101 - 50) + 50;
        return numberTrainees;
    }

    public  static int getNumberOfTraineesForCenter(){
        Random random = new Random();
        int numberTrainees = random.nextInt(51);
        return numberTrainees;
    }

    public static String getRandomCourse(){
        Random random = new Random();
        int courseSelector = random.nextInt(5);
        String[] courses = {"Java", "C#","Data","DevOps","Business"};
        return courses[courseSelector];
    }
}
