package com.sparta.ss.trainingcentre;

import com.sparta.ss.RandomGenerator;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class TrainingHub {

    private ArrayList<Trainee> occupiedSeats = new ArrayList<>();
    private boolean isOpen = true;

    public void setOccupiedSeats(int seatsToOccupy) {
        while(seatsToOccupy != 0){
            this.occupiedSeats.add(new Trainee());
            seatsToOccupy--;
        }
    }

    private boolean maxChecker() {
        return this.occupiedSeats.size() <= 100;
    }

    public int getEmptySpaces(){
        return 100 - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public static void allocateTrainees() {
        SpartaSimulatorLogger.InfoMessage("Allocating trainees to Training Hub");
        for (TrainingHub hub : TrainingCenterManager.trainingHubs) {
            if (TraineeManager.getWaitingList().size() > 0 && hub.isOpen) {
                putIntoTrainingCentre(TraineeManager.getWaitingList(), hub);
            } else if(TraineeManager.getTrainees().size() > 0 && hub.isOpen){
                putIntoTrainingCentre(TraineeManager.getTrainees(), hub);
            }
        }
        while (TraineeManager.getTrainees().size() != 0){
            TraineeManager.getWaitingList().add(new Trainee());
            TraineeManager.getTrainees().remove(0);
        }

    }

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TrainingHub hub) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        while(amountToAllocate >= trainees.size() ) {
            if (amountToAllocate > trainees.size()) {
                amountToAllocate = trainees.size();
            }
            if (amountToAllocate + hub.occupiedSeats.size() < 100) {
                hub.occupiedSeats.add(trainees.get(0));
                trainees.remove(0);

            } else if (amountToAllocate + hub.occupiedSeats.size() == 100) {
                hub.occupiedSeats.add(trainees.get(0));
                hub.isOpen = false;
                trainees.remove(0);
                return trainees;

            } else {
                while(hub.getEmptySpaces() != 0){
                    hub.occupiedSeats.add(trainees.get(0));
                    trainees.remove(0);
                }
                hub.isOpen = false;
                return trainees;
            }
        }
        return trainees;

    }




}
