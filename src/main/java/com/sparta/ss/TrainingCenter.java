package com.sparta.ss;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenter {
        private int vacancySeats;
        private int occupiedSeats;
        private int maxLimit = 100;
        private boolean isOpen = true;

        public static List<TrainingCenter> openTrainingCenter = new ArrayList<>();
        public static List<TrainingCenter> fullTrainingCenter = new ArrayList<>();

    public TrainingCenter() {
        this.vacancySeats = 100;
        this.occupiedSeats = 100 - this.vacancySeats;
    }

    public void setVacancySeats(int vacancySeats) {
        this.vacancySeats = vacancySeats;
        this.occupiedSeats = 100 - vacancySeats;
    }


    private void allocateTrainees(int numberTrainees){
        //just need to randomize the numberTrainees we assign to each center.
        // Probably something in else break. Maybe use list of randomly generated ints instead of numberTrainees?
        for (TrainingCenter centre : openTrainingCenter) {
            if (numberTrainees > 0){
                if (numberTrainees + centre.occupiedSeats < 100) {
                    centre.occupiedSeats += numberTrainees;
                    numberTrainees = 0;
                } else if (numberTrainees + centre.occupiedSeats == 100) {
                    centre.occupiedSeats += numberTrainees;
                    numberTrainees = 0;
                    centre.isOpen = false;
                } else {
                    numberTrainees = numberTrainees - centre.vacancySeats;
                    centre.occupiedSeats = 100;
                    centre.isOpen = false;
                }
            } else {
                break;
            }
        }
    }


        public void checkVacancy(){
            checkIfFull();
        }

        private void checkIfFull(){
            if(occupiedSeats == maxLimit){
                isOpen = false;
            }
        }
    }

