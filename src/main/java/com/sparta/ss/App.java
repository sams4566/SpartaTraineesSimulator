package com.sparta.ss;

import com.sparta.ss.config.ConfigFilename;
import com.sparta.ss.logs.SpartaSimulatorLogger;

public class App
{
    public static void main( String[] args )
    {   SpartaSimulatorLogger.createHandler();
        SpartaSimulatorLogger.InfoMessage("Starting from main method");
        MonthIterator.monthIterator(ConfigFilename.filename);
    }
}
