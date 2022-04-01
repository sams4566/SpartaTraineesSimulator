package com.sparta.ss.trainingcentre;

import com.sparta.ss.trainee.TraineeManager;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {
//
//    private static List<TrainingCenter> trainingCenters = new ArrayList<>();

    private static List<TrainingHub> trainingHubs = new ArrayList<>();

    private static List<TechCentre> techCenters = new ArrayList<>();

    private static List<BootcampCenter> bootcampCenters = new ArrayList<>();





    public static int getClosedTrainingHubs() {
        return closedTrainingHubs;
    }

    public static int getClosedTechCentres() {
        return closedTechCentres;
    }

    public static int getClosedBootcampCentres() {
        return closedBootcampCentres;
    }

    static int closedTechCentres = 0;
    static int closedBootcampCentres = 0;
    static int closedTrainingHubs = 0;


    public static  void resetClosedTrainingCentres(){
        closedTechCentres = 0;
        closedBootcampCentres = 0;
        closedTrainingHubs = 0;
    }
    public static void removeLowAttendanceBootcamp() {
        if(bootcampCenters.size() == 0){
        }else {
            for (int i = 0; i<bootcampCenters.size() ; i++) {
                if (bootcampCenters.get(i).getOccupiedSeats() < 25 && bootcampCenters.get(i).getConsLowAttendance() == 3) {
                    for(int j = 0; j < bootcampCenters.get(i).getOccupiedSeats();j++){
                        TraineeManager.getWaitingList().add(bootcampCenters.get(i).getOccupiedSeatsList().get(j));
                    }
                    bootcampCenters.remove(bootcampCenters.get(i));
                    closedBootcampCentres ++;
                    i --;
                } else if (bootcampCenters.get(i).getOccupiedSeats() < 25) {
                    bootcampCenters.get(i).increaseConsLowAttendance();
                }
            }
        }
    }

    public static void removeLowAttendanceTrainingHub() {
        if(trainingHubs.size() == 0){
        }else {
            for (int i = 0;i<trainingHubs.size(); i++) {
                if (trainingHubs.get(i).getOccupiedSeats() < 25) {
                    for(int j = 0; j < trainingHubs.get(i).getOccupiedSeats();j++){
                        TraineeManager.getWaitingList().add(trainingHubs.get(i).getOccupiedSeatsList().get(j));
                    }
                    trainingHubs.remove(trainingHubs.get(i));
                    closedTrainingHubs ++;
                    i --;
                }
            }
        }
    }

    public static void removeLowAttendanceTechcentre() {
        if(techCenters.size() == 0){
        }else {
            for (int i = 0;i<techCenters.size(); i++) {
                if (techCenters.get(i).getOccupiedSeats() < 25) {
                    for(int j = 0; j < techCenters.get(i).getOccupiedSeats();j++){
                        TraineeManager.getWaitingList().add(techCenters.get(i).getOccupiedSeatsList().get(j));
                    }
                    techCenters.remove(techCenters.get(i));
                    closedTechCentres ++;
                    i --;
                }
            }
        }
    }

    public static List<BootcampCenter> getBootcampCenters() {
        return bootcampCenters;
    }

    public static List<TechCentre> getTechCenters() {return techCenters; }

    public static int getTotCenters() {
        return techCenters.size() + bootcampCenters.size() + trainingHubs.size();
    }

    public static List<TrainingHub> getTrainingHub() {
        return trainingHubs;
    }


    public static int getTraineesInTraining(String course){
        int counter = 0;

        for(TrainingHub trainingHub : trainingHubs){
            counter += trainingHub.getOccupiedSeatsList().stream().filter(trainee -> trainee.getCourse().equals(course)).count();
        }
        for(TechCentre techCentre : techCenters){
            counter += techCentre.getOccupiedSeatsList().stream().filter(trainee -> trainee.getCourse().equals(course)).count();
        }
        for(BootcampCenter bootcampCenter : bootcampCenters){
            counter += bootcampCenter.getOccupiedSeatsList().stream().filter(trainee -> trainee.getCourse().equals(course)).count();
        }
        return counter;
    }
  
    public static int getFullTrainingHubCount(){
        return (int) trainingHubs.stream().filter(trainingHub -> !trainingHub.checkVacancy()).count();
    }

    public static int getFullTechCenterCount(){
        return (int) techCenters.stream().filter(techCentre -> !techCentre.checkVacancy()).count();
    }

    public static int getFullBootCampCount(){
        return (int) bootcampCenters.stream().filter(bootcampCenter -> !bootcampCenter.checkVacancy()).count();

    }

    public static int getOpenBootCampCount(){
        return (int) bootcampCenters.stream().filter(bootcampCenter -> bootcampCenter.checkVacancy()).count();
    }

    public static int getOpenTechCentersCount(){
        return (int) techCenters.stream().filter(techCentre -> techCentre.checkVacancy()).count();
    }
    public static int getOpenTrainingHubCount(){
        return (int) trainingHubs.stream().filter(trainingHub -> trainingHub.checkVacancy()).count();
    }
    public static void removeAllCentres(){
        trainingHubs.clear();
        techCenters.clear();
        bootcampCenters.clear();
    }
}
