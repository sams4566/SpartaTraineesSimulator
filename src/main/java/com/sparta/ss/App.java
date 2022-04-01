package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.logs.ConsoleLogger;
import com.sparta.ss.logs.SpartaSimulatorLogger;

public class App
{
    public static void main( String[] args )
    {   SpartaSimulatorLogger.createHandler();
        ConsoleLogger.createHandler();
        SpartaSimulatorLogger.InfoMessage("Starting the simulator");
        ConsoleLogger.InfoMessage("Starting the simulator");
        MonthIterator.monthIterator(ConfigFilename.filename);
        ConsoleLogger.InfoMessage("Ending the simulator");
    }
}
