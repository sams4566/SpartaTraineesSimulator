package com.sparta.ss.start;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.logs.ConsoleLogger;
import com.sparta.ss.logs.SpartaSimulatorLogger;

public class Start {
    public static void start()
    {   SpartaSimulatorLogger.createHandler();
        ConsoleLogger.createHandler();
        SpartaSimulatorLogger.InfoMessage("Starting the simulator");
        ConsoleLogger.InfoMessage("Starting the simulator");
        MonthIterator.monthIterator(ConfigFilename.filename);
        ConsoleLogger.InfoMessage("Ending the simulator");
    }
}
