package com.example.bm_project.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSingleton {
    private static LoggerSingleton instance;
    private Logger logger;

    private LoggerSingleton() {
        //Initialize Logger
        logger = LoggerFactory.getLogger(LoggerSingleton.class);
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            synchronized (LoggerSingleton.class) {
                if (instance == null) {
                    instance = new LoggerSingleton();
                }
            }
        }
        return instance;
    }

    public void logInfo(Class<?> className,String message) {
        logger.info("LogMsg in class <"+ className.getSimpleName() + ">: "+ message);
    }

    public void logDebug(Class<?> className,String message) {
        logger.debug("LogMsg in class <"+ className.getSimpleName() + ">: "+ message);
    }

    public void logError(Class<?> className,String message) {
        logger.error("LogMsg in class <"+ className.getSimpleName() + ">: "+ message);
    }
}