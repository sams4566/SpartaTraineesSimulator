package com.sparta.ss.trainingcentre;

import com.sparta.ss.RandomGenerator;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class TrainingCenter {
    private ArrayList<Trainee> occupiedSeats;
    private boolean isOpen = true;

    private boolean maxChecker() {
        return this.occupiedSeats.size() != 100;
    }

    public int getEmptySpaces(){
        return 100 - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public static void allocateTrainees() {
        SpartaSimulatorLogger.InfoMessage("Allocating trainees");
        for (TrainingCenter centre : TrainingCenterManager.trainingCenters) {
            if (TraineeManager.getWaitingList().size() > 0 && centre.isOpen) {
                putIntoTrainingCentre(TraineeManager.getWaitingList(), centre);
            } else if(TraineeManager.getTrainees().size() > 0 && centre.isOpen){
                putIntoTrainingCentre(TraineeManager.getTrainees(), centre);
            }
        }
        while (TraineeManager.getTrainees().size() != 0){
            TraineeManager.getWaitingList().add(new Trainee());
            TraineeManager.getTrainees().remove(0);
        }

    }

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TrainingCenter centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        while(amountToAllocate >= trainees.size() ) {
            if (amountToAllocate > trainees.size()) {
                amountToAllocate = trainees.size();
            }
            if (amountToAllocate + centre.occupiedSeats.size() < 100) {
                centre.occupiedSeats.add(trainees.get(0));
                trainees.remove(0);

            } else if (amountToAllocate + centre.occupiedSeats.size() == 100) {
                centre.occupiedSeats.add(trainees.get(0));
                centre.isOpen = false;
                trainees.remove(0);
                return trainees;

            } else {
                while(centre.getEmptySpaces() != 0){
                    centre.occupiedSeats.add(trainees.get(0));
                    trainees.remove(0);
                }
                centre.isOpen = false;
                return trainees;
            }
        }
        return trainees;

    }



    public boolean checkVacancy() {
        return maxChecker();
    }

}


