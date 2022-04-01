package com.sparta.ss.logs;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpartaSimulatorLogger {
    public static Logger logger = Logger.getLogger("spartaSimulatorLogger");

    public static void createHandler(){
            try {
                Handler fileHandler = new FileHandler("src/main/java/com/sparta/ss/logs/SpartaSimulatorLog.log",true);
                logger.addHandler(fileHandler);
                fileHandler.setFormatter(new CustomFormatter());
                logger.setUseParentHandlers(false);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void InfoMessage(String Message){

        logger.log(Level.INFO,Message);
    }

    public static void warningMessage(String Message){

        logger.log(Level.WARNING,Message);
    }


}
