package com.sparta.ss.trainingcentre;

import com.sparta.ss.trainingcentre.TrainingCenter;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {

    private static List<TrainingCenter> trainingCenters = new ArrayList<>();

    private static List<TrainingHub> trainingHubs = new ArrayList<>();

    private static List<TechCentre> techCenters = new ArrayList<>();

    private static List<BootcampCenter> bootcampCenters = new ArrayList<>();

    static int closedTrainingHubs = 0;

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

    public static void removeLowAttendanceBootcamp() {
        if(bootcampCenters.size() == 0){
        }else {
            for (int i = 0; i<bootcampCenters.size() ; i++) {
                if (bootcampCenters.get(i).getOccupiedSeats() < 25 && bootcampCenters.get(i).getConsLowAttendance() == 3) {
                    bootcampCenters.remove(bootcampCenters.get(i));
                    closedBootcampCentres ++;
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
                    trainingHubs.remove(trainingHubs.get(i));
                    closedTrainingHubs ++;
                }
            }
        }
    }

    public static void removeLowAttendanceTechcentre() {
        if(techCenters.size() == 0){
        }else {
            for (int i = 0;i<techCenters.size(); i++) {
                if (techCenters.get(i).getOccupiedSeats() < 25) {
                    techCenters.remove(techCenters.get(i));
                    closedTechCentres ++;
                }
            }
        }
    }

    public static List<BootcampCenter> getBootcampCenters() {
        return bootcampCenters;
    }

    public static void removeAllTrainingCenter(){
         trainingCenters.removeAll(trainingCenters);
    }

    public static List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public static List<TechCentre> getTechCenters() {return techCenters; }

    public static int getTotCenters() {
        return trainingCenters.size();
    }

    public static List<TrainingHub> getTrainingHub() {
        return trainingHubs;
    }

    public static int getFullCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).count();
    }

    public static int getFullBootcampCenters(){
        return (int) bootcampCenters.stream().filter(bootcampCenter -> !bootcampCenter.checkVacancy()).count();
    }

    public static int getFullTrainingHubs(){
        return (int) trainingHubs.stream().filter(trainingHubs -> !trainingHubs.checkVacancy()).count();
    }

    public static int getFullTechCenters(){
        return (int) techCenters.stream().filter(techCenters -> !techCenters.checkVacancy()).count();
    }

    public static int getOpenCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).count();
    }

    public static int getOpenBootcampCenters() {
        return (int) bootcampCenters.stream().filter(bootcampCenter -> bootcampCenter.checkVacancy()).count();
    }

    public static int getOpenTrainingHubs() {
        return (int) trainingHubs.stream().filter(trainingHub -> trainingHub.checkVacancy()).count();
    }

    public static int getOpenTechCenters() {
        return (int) techCenters.stream().filter(techCentre -> techCentre.checkVacancy()).count();
    }

    public static int getNumberTraineesInTraining(){
        int countTrainees = 0;
        for(TrainingCenter trainingCenter : trainingCenters){
            countTrainees += trainingCenter.getOccupiedSeats();
        }
        return countTrainees;
    }


    public static int getNumberOfBootcampCenterTrainees(){
        int countTrainees = 0;
        for(BootcampCenter bootcampCenter : bootcampCenters){
            countTrainees += bootcampCenter.getOccupiedSeats();
        }
        return countTrainees;
    }

    public static int getNumberOfTechCenterTrainees(){
        int countTrainees = 0;
        for(TechCentre techCentre : techCenters){
            countTrainees += techCentre.getOccupiedSeats();
        }
        return countTrainees;
    }

    public static int getNumberOfTrainingHubTrainees(){
        int countTrainees = 0;
        for(TrainingHub trainingHub : trainingHubs){
            countTrainees += trainingHub.getOccupiedSeats();
        }
        return countTrainees;
    }

    public static int getFullTrainingHubCount(){
        return (int) trainingHubs.stream().filter(trainingHub -> !trainingHub.checkVacancy()).count();
    }

    public static int getFullTechCenterCount(){
        return (int) techCenters.stream().filter(techCentre -> !techCentre.checkVacancy()).count();
    }

    public static int getFullBootCampCount(){
        return (int) bootcampCenters.stream().filter(bootcampCenter -> !bootcampCenter.checkVacancy()).count();

    } public static int getOpenTrainingHubCount(){
        return (int) trainingHubs.stream().filter(trainingHub -> trainingHub.checkVacancy()).count();
    }

    public static int getOpenTechCenterCount(){
        return (int) techCenters.stream().filter(techCentre -> techCentre.checkVacancy()).count();
    }

    public static int getOpenBootCampCount(){
        return (int) bootcampCenters.stream().filter(bootcampCenter -> bootcampCenter.checkVacancy()).count();
    }



    public static int getOpenTechCentersCount(){
        return (int) techCenters.stream().filter(techCentre -> techCentre.checkVacancy()).count();
    }
}
