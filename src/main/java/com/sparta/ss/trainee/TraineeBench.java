package com.sparta.ss.trainee;

import java.util.ArrayList;

public class TraineeBench {

    public static ArrayList<Trainee> benchTrainees = new ArrayList<>();

    public static void gettingTraineesToBench() {
        int count = 0;
        while (count<TraineeManager.currentlyTrainingTrainees.size())
            if(TraineeManager.currentlyTrainingTrainees.get(count).getTrainingTime() == 11){
                benchTrainees.add(TraineeManager.currentlyTrainingTrainees.get(count));
                TraineeManager.currentlyTrainingTrainees.remove(count);
            }else {
                TraineeManager.currentlyTrainingTrainees.get(count).setTrainingTime(TraineeManager.currentlyTrainingTrainees.get(count).getTrainingTime() + 1);
                count++;
            }
        }
    }

