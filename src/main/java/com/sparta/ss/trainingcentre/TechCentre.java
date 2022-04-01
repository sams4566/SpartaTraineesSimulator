package com.sparta.ss.trainingcentre;

import com.sparta.ss.utilities.RandomGenerator;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class TechCentre {
    private static final int maxTrainee = 200;
    private ArrayList<Trainee> occupiedSeats = new ArrayList<>();
    private boolean isOpen = true;
    private String course;

    public void setOccupiedSeats(int seatsToOccupy) {
        while(seatsToOccupy != 0){
            this.occupiedSeats.add(new Trainee());
            seatsToOccupy--;
        }
    }


    public TechCentre() {
        this.course = RandomGenerator.getRandomCourse();
    }

    private boolean maxChecker() {
        return this.occupiedSeats.size() < maxTrainee;
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public ArrayList<Trainee> getOccupiedSeatsList() {
        return occupiedSeats;
    }

    public static ArrayList<Trainee> allocateTrainees() {
        ArrayList<Trainee> trainees = new ArrayList<>();
        for (TechCentre centre : TrainingCenterManager.getTechCenters()) {
            if (TraineeManager.getWaitingList().size() > 0 && centre.isOpen) {
                trainees = putIntoTrainingCentre(TraineeManager.getWaitingList(), centre);
            } else if(TraineeManager.getTrainees().size() > 0 && centre.isOpen){
                trainees = putIntoTrainingCentre(TraineeManager.getTrainees(), centre);
            }
        }
        return trainees;
    }

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TechCentre centre) {
         int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
         int count = 0;
         if (amountToAllocate > trainees.size()) {
             amountToAllocate = trainees.size();
         }
         while(count < trainees.size() && amountToAllocate != 0) {
             if (trainees.get(count).getCourse().equals(centre.course)) {
                 if (centre.occupiedSeats.size() < 199) {
                     TraineeManager.currentlyTrainingTrainees.add(trainees.get(count));
                     centre.occupiedSeats.add(trainees.get(count));
                     trainees.remove(count);
                     amountToAllocate--;
                 } else if (centre.occupiedSeats.size() == 199) {
                     centre.occupiedSeats.add(trainees.get(count));
                     TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                     centre.isOpen = false;
                     trainees.remove(0);
                     return trainees;
                 } else {
                     centre.isOpen = false;
                     return trainees;
                 }
             }
             count++;
         }
        return trainees;
    }




    public boolean checkVacancy() {
        return maxChecker();
    } 
}
