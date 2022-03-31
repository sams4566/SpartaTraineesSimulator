package com.sparta.ss.trainingcentre;

import com.sparta.ss.utilities.RandomGenerator;
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
        return this.occupiedSeats.size() < maxTrainee;
    }

    public int getEmptySpaces(){
        return maxTrainee - occupiedSeats.size();
    }

    public int getOccupiedSeats() {
        return occupiedSeats.size();
    }

    public ArrayList<Trainee> getOccupiedSeatsList() {
        return occupiedSeats;
    }

    public static ArrayList<Trainee> allocateTrainees() {
        ArrayList<Trainee> trainees = new ArrayList<>();
        for (TechCentre centre : TrainingCenterManager.getTechCenters()) {
            if (TraineeManager.getWaitingList().size() > 0 && centre.isOpen) {
                trainees = putIntoTrainingCentre(TraineeManager.getWaitingList(), centre);
            } else if(TraineeManager.getTrainees().size() > 0 && centre.isOpen){
                trainees = putIntoTrainingCentre(TraineeManager.getTrainees(), centre);
            }
        }
        return trainees;
    }

    private static ArrayList<Trainee> putIntoTrainingCentre(ArrayList<Trainee> trainees, TechCentre centre) {
        int amountToAllocate = RandomGenerator.getNumberOfTraineesForCenter();

//         if (amountToAllocate > trainees.size()) {
//             amountToAllocate = trainees.size();
//         }
//         for(int i = 0; i < trainees.size(); i++ ){
//             if(trainees.get(i).getCourse().equals(centre.course)) {
//                 if (centre.occupiedSeats.size() < 199) {
//                     centre.occupiedSeats.add(trainees.get(i));
//                     trainees.remove(0);

//                 } else if (centre.occupiedSeats.size() == 199) {
//                     centre.occupiedSeats.add(trainees.get(i));

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

//                     while (centre.getEmptySpaces() != 0) {
//                         centre.occupiedSeats.add(trainees.get(0));
//                         TraineeManager.currentlyTrainingTrainees.add(trainees.get(0));
//                         trainees.remove(0);
//                     }

                    centre.isOpen = false;
                    return trainees;
                }
                amountToAllocate--;
            }

        }
        return trainees;
    }




    public boolean checkVacancy() {
        return maxChecker();
    } 
}
