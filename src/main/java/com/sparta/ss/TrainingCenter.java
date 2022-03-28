package com.sparta.ss;

public class TrainingCenter {
        private int vacancySeats;
        private int occupiedSeats;
        private int maxLimit = 100;
        private boolean isOpen = true;

    public TrainingCenter(int vacancySeats, int occupiedSeats) {
        this.vacancySeats = vacancySeats;
        this.occupiedSeats = occupiedSeats;
    }


    private void allocatetrainees(){
            // require random generator
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

