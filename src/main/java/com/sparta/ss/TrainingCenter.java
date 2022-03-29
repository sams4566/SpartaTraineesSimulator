package com.sparta.ss;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenter {
    private int vacancySeats;
    private int occupiedSeats;
    private int maxLimit = 100;
    private boolean isOpen = true;


    public TrainingCenter() {
        this.vacancySeats = 100;
        this.occupiedSeats = 100 - this.vacancySeats;
    }

    public void setVacancySeats(int vacancySeats) {
        this.vacancySeats = vacancySeats;
        this.occupiedSeats = 100 - vacancySeats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public static int allocateTrainees(int waitingList, int randomTraineeNumber) {
        for (TrainingCenter centre : TrainingCenterManager.trainingCenters) {
            if (waitingList > 0 && centre.isOpen) {
                waitingList = putIntoTrainingCentre(waitingList, centre);
            } else if(randomTraineeNumber > 0 && centre.isOpen){
                randomTraineeNumber = putIntoTrainingCentre(randomTraineeNumber, centre);
            }
            else{
                return waitingList;
            }
        }
        waitingList += randomTraineeNumber;
        return waitingList;
    }

    private static int putIntoTrainingCentre(int trainees, TrainingCenter centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        if(amountToAllocate > trainees) {
            amountToAllocate = trainees;
        }
        if (amountToAllocate + centre.occupiedSeats < 100) {
            centre.occupiedSeats += amountToAllocate;
            trainees -= amountToAllocate;
            return trainees;
        } else if (amountToAllocate + centre.occupiedSeats == 100) {
            centre.occupiedSeats += amountToAllocate;
            centre.isOpen = false;
            trainees -= amountToAllocate;
            return trainees;
        } else {
            trainees -= centre.vacancySeats;
            centre.occupiedSeats = 100;
            centre.isOpen = false;
            return trainees;
        }

    }

    public boolean checkVacancy() {
        return checkIfFull();
    }

    private boolean checkIfFull() {
        if (occupiedSeats == maxLimit) {
            isOpen = false;
        }
        return isOpen;
    }
}


