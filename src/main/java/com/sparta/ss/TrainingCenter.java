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

    public static int allocateTrainees(int waitingList, int randomTraineeNumber) {
        int placeholder = 0;
        for (TrainingCenter centre : TrainingCenterManager.trainingCenters) {
            if (waitingList > 0) {
                if(centre.isOpen) {
                    waitingList = putIntoTrainingCentre(waitingList, centre);
                }
            } else if(randomTraineeNumber > 0){
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
        int placeholder;
        if (trainees + centre.occupiedSeats < 100) {
            placeholder = centre.occupiedSeats;
            centre.occupiedSeats += trainees;
            trainees -= centre.occupiedSeats - placeholder;
            return trainees;
        } else if (trainees + centre.occupiedSeats == 100) {
            placeholder = centre.occupiedSeats;
            centre.occupiedSeats += trainees;
            centre.isOpen = false;
            trainees -= centre.occupiedSeats - placeholder;
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


