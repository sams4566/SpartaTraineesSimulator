package com.sparta.ss;

import com.sparta.ss.view.PrintOut;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        CurrentlyTrainingTrainees trainees = new CurrentlyTrainingTrainees();
        trainees.addTrainingTrainees(10);   //Everytime when trainees add to training centre
        System.out.print("Currently Training Trainees after 1st month: ");
        System.out.println(trainees.getTrainingTrainees());
        trainees.addTrainingTrainees(20);
        System.out.print("Currently Training Trainees after 2nd month: ");
        System.out.println(trainees.getTrainingTrainees());
        trainees.addTrainingTrainees(15);
        System.out.print("Currently Training Trainees after 3rd month: ");
        System.out.println(trainees.getTrainingTrainees());
    }
}
