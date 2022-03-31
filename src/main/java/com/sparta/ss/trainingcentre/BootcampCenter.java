package com.sparta.ss.trainingcentre;

public class BootcampCenter extends TrainingCenter{

    int consLowAttendance = 0;

    private boolean isCenterFull(){
        return getOccupiedSeats() == 500;
    }

    public void setConsLowAttendance(int consLowAttendance) {
        this.consLowAttendance = consLowAttendance;
    }


    public static void main(String[] args) {

        BootcampCenter bootcampCenter = new BootcampCenter();



    }

}
