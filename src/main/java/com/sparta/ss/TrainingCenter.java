package com.sparta.ss;

public abstract class TrainingCenter {
        private int vacancySeats;
        private int occupiedSeats;
        private int maxLimit = 100;
        private boolean isOpen = true;


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

