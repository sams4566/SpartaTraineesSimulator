package com.sparta.ss.trainee;

import com.sparta.ss.RandomGenerator;

public class Trainee {
    String course;
    int trainingTime;


    public int getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }


    public Trainee() {

        this.course = RandomGenerator.getRandomCourse();
        this.trainingTime = 0;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
