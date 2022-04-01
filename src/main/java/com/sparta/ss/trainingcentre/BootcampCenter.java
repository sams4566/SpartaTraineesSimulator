package com.sparta.ss.trainingcentre;

import com.sparta.ss.utilities.RandomGenerator;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class BootcampCenter {

    int consLowAttendance = 1;
    private ArrayList<Trainee> occupiedSeats = new ArrayList<>();
    private boolean isOpen = true;

    public static int getMaxBootcamp() {
        return maxBootcamp;
    }

    private static int maxBootcamp = 2;


    public void increaseConsLowAttendance() {
        this.consLowAttendance ++;
    }

    public void setOccupiedSeats(int seatsToOccupy) {
        while(seatsToOccupy != 0){
            this.occupiedSeats.add(new Trainee());
            seatsToOccupy--;
        }
    }

    public int getConsLowAttendance() {
        return consLowAttendance;
    }

    public boolean maxChecker() {
        return this.occupiedSeats.size() < 500;
    }

    public int getEmptySpaces(){
        return 500 - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public ArrayList<Trainee> getOccupiedSeatsList() {
        return occupiedSeats;
    }

    public static void allocateTrainees() {
        for (BootcampCenter centre : TrainingCenterManager.getBootcampCenters()) {
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

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, BootcampCenter centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        if (amountToAllocate > trainees.size()) {
            amountToAllocate = trainees.size();
        }
        while(amountToAllocate > 0 ) {
            if (centre.occupiedSeats.size() < 499) {
                centre.occupiedSeats.add(trainees.get(0));
                TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                trainees.remove(0);

            } else if (centre.occupiedSeats.size() == 499) {
                centre.occupiedSeats.add(trainees.get(0));
                TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                centre.isOpen = false;
                trainees.remove(0);
                return trainees;

            } else {

                while(centre.getEmptySpaces() != 0){
                    centre.occupiedSeats.add(trainees.get(0));
                    TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                    trainees.remove(0);
                }
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
