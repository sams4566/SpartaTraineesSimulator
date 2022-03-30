package com.sparta.ss.trainee;

import java.util.ArrayList;

public class TraineeManager {
    static ArrayList<Trainee> trainees = new ArrayList<>();
    public static ArrayList<Trainee> waitingList = new ArrayList<>();

    public static void removeAllTraineesFromWaitingList(){
        waitingList.removeAll(waitingList);
    }

    public static ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public static ArrayList<Trainee> getWaitingList() {
        return waitingList;
    }
}
