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


    private void allocatetrainees() {
        // require random generator
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

