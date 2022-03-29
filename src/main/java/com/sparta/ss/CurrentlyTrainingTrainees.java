package com.sparta.ss;

public class CurrentlyTrainingTrainees {

    private static int trainees;

    public void setTrainingTrainees(int trainees) {
        this.trainees = trainees;
    }


    public int getTrainingTrainees() {
        return trainees;
    }

    public void addTrainingTrainees(int trainees) {
        setTrainingTrainees(getTrainingTrainees() + trainees);
    }

}
