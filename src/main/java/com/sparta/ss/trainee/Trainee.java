package com.sparta.ss.trainee;

import com.sparta.ss.utilities.RandomGenerator;

public class Trainee {
    String course;

    public Trainee() {
        this.course = RandomGenerator.getRandomCourse();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
