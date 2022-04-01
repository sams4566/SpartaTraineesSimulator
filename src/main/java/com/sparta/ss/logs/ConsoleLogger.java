package com.sparta.ss.logs;

import java.util.logging.*;

public class ConsoleLogger {
    public static Logger consoleLogger = Logger.getLogger("spartaSimulatorConsoleLogger");
    public static void createHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleLogger.addHandler(consoleHandler);
        consoleHandler.setFormatter(new CustomFormatter());
        consoleLogger.setUseParentHandlers(false);
    }

    public static void InfoMessage(String Message){

        consoleLogger.log(Level.INFO,Message);
    }
}
