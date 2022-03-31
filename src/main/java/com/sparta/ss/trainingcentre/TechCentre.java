package com.sparta.ss.trainingcentre;

import com.sparta.ss.RandomGenerator;
import com.sparta.ss.logs.SpartaSimulatorLogger;
import com.sparta.ss.trainee.Trainee;
import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;

public class TechCentre {
    private static final int maxTrainee = 200;
    private ArrayList<Trainee> occupiedSeats = new ArrayList<>();
    private boolean isOpen = true;
    private String course;

    public void setOccupiedSeats(int seatsToOccupy) {
        while(seatsToOccupy != 0){
            this.occupiedSeats.add(new Trainee());
            seatsToOccupy--;
        }
    }

    public TechCentre() {
        this.course = RandomGenerator.getRandomCourse();
    }

    public boolean isLessThan25() { return occupiedSeats.size() <= 25; }

    private boolean maxChecker() {
        return this.occupiedSeats.size() <= maxTrainee;
    }

    public int getEmptySpaces(){
        return maxTrainee - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public static void allocateTrainees() {
        SpartaSimulatorLogger.InfoMessage("Allocating trainees to Tech Centre");
        for (TechCentre centre : TrainingCenterManager.getTechCenters()) {
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

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TechCentre centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();
        while(amountToAllocate >= trainees.size() ) {
            if (amountToAllocate > trainees.size()) {
                amountToAllocate = trainees.size();
            }
            if(trainees.get(0).getCourse().equals(centre.course)) {
                if (amountToAllocate + centre.occupiedSeats.size() < maxTrainee) {
                    centre.occupiedSeats.add(trainees.get(0));
                    TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                    trainees.remove(0);

                } else if (amountToAllocate + centre.occupiedSeats.size() == maxTrainee) {
                    centre.occupiedSeats.add(trainees.get(0));
                    TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                    centre.isOpen = false;
                    trainees.remove(0);
                    return trainees;

                } else {
                    while (centre.getEmptySpaces() != 0) {
                        centre.occupiedSeats.add(trainees.get(0));
                        TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
                        trainees.remove(0);
                    }
                    centre.isOpen = false;
                    return trainees;
                }
            }
        }
        return trainees;

    }

    public boolean checkVacancy() {
        return maxChecker();
    } 
}
