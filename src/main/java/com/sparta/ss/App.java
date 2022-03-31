package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.logs.SpartaSimulatorLogger;

public class App
{
    public static void main( String[] args )
    {   SpartaSimulatorLogger.createHandler();
        SpartaSimulatorLogger.InfoMessage("Starting the simulator");
        System.out.println("Starting the simulator");
        MonthIterator.monthIterator(ConfigFilename.filename);
        System.out.println("Ending the simulation");
    }
}
