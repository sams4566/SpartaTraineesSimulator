package com.sparta.ss.utilities;

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

    public static String getRandomTrainingCenter(){
        Random random = new Random();
        int trainingCenterSelector = random.nextInt(3);
        String[] trainingCenter = {"TrainingHub", "BootCamp","TechCenter"};
        return trainingCenter[trainingCenterSelector];
    }

    public static String getRandomTrainingCenterTwo(){
        Random random = new Random();
        int trainingCenterSelector = random.nextInt(2);
        String[] trainingCenter = {"TrainingHub", "BootCamp"};
        return trainingCenter[trainingCenterSelector];
    }

}
