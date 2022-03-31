package com.sparta.ss.trainingcentre;

import com.sparta.ss.trainingcentre.TrainingCenter;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenterManager {

    public static List<TrainingCenter> trainingCenters = new ArrayList<>();

    public static List<TrainingHub> trainingHubs = new ArrayList<>();

    public static List<TechCentre> techCenters = new ArrayList<>();

    public static List<BootcampCenter> bootcampCenters = new ArrayList<>();

    public static void removeLowAttendanceBootcamp() {
        int countTrainees = 0;
        for(BootcampCenter center : bootcampCenters){
            countTrainees += center.getOccupiedSeats();
            if (countTrainees < 25 && center.consLowAttendance == 3) {
                bootcampCenters.remove(center);
            }else if(countTrainees < 25){
                center.consLowAttendance ++;
            }
        }
    }

    public static void removeLowAttendanceTrainingHub() {
        int countTrainees = 0;
        for(TrainingHub center : trainingHubs){
            countTrainees += center.getOccupiedSeats();
            if (countTrainees < 25) {
                trainingHubs.remove(center);
            }
        }
    }

    public static void removeLowAttendanceTechcentre() {
        int countTrainees = 0;
        for(TechCentre center : techCenters){
            countTrainees += center.getOccupiedSeats();
            if (countTrainees < 25) {
                techCenters.remove(center);
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

    public static int getOpenCenters(){
        return (int) trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).count();
    }

    public static int getNumberTraineesInTraining(){
        int countTrainees = 0;
        for(TrainingCenter trainingCenter : trainingCenters){
            countTrainees += trainingCenter.getOccupiedSeats();
        }
        return countTrainees;
    }

    public static List<TrainingCenter> getEmptyCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> trainingCenter.checkVacancy()).toList();
    }

    public static List<TrainingCenter> getFullCentersList(){
        return trainingCenters.stream().filter(trainingCenter -> !trainingCenter.checkVacancy()).toList();
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

}
