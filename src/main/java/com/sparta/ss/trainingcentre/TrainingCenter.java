package com.sparta.ss.trainingcentre;

import com.sparta.ss.utilities.RandomGenerator;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class TrainingCenter {

    public void setOccupiedSeats(int seatsToOccupy) {
        while(seatsToOccupy != 0){
            this.occupiedSeats.add(new Trainee());
            seatsToOccupy--;
        }

    }

    private ArrayList<Trainee> occupiedSeats = new ArrayList<>();
    private boolean isOpen = true;

    private boolean maxChecker() {
        return this.occupiedSeats.size() < 100;
    }

    public int getEmptySpaces(){
        return 100 - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public static void allocateTrainees() {
        for (TrainingCenter centre : TrainingCenterManager.getTrainingCenters()) {
            if (TraineeManager.getWaitingList().size() > 0 && centre.isOpen) {
                putIntoTrainingCentre(TraineeManager.getWaitingList(), centre);

            } else if(TraineeManager.getTrainees().size() > 0 && centre.isOpen){
                putIntoTrainingCentre(TraineeManager.getTrainees(), centre);
            }
        }
        while (TraineeManager.getTrainees().size() != 0){
            TraineeManager.getWaitingList().add(TraineeManager.getTrainees().get(0));
            TraineeManager.getTrainees().remove(0);
        }
    }

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TrainingCenter centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        if (amountToAllocate > trainees.size()) {
            amountToAllocate = trainees.size();
        }
        while(amountToAllocate > 0 ) {
            if (centre.occupiedSeats.size() < 99) {
                centre.occupiedSeats.add(trainees.get(0));
                trainees.remove(0);

            } else if (centre.occupiedSeats.size() == 99) {
                centre.occupiedSeats.add(trainees.get(0));
                centre.isOpen = false;
                trainees.remove(0);
                return trainees;

            } else {
                centre.isOpen = false;
                return trainees;
            }
            amountToAllocate--;
        }
        return trainees;
    }



    public boolean checkVacancy() {
        return maxChecker();
    }

}


