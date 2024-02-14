package com.example.currencyapp.logger;

import org.slf4j.LoggerFactory;

public class Logger {
    private static Logger instance;
    private final org.slf4j.Logger logger;

    private Logger() {
        //Initialize Logger
        logger = LoggerFactory.getLogger(Logger.class);
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void logInfo(Class<?> className,String message) {
        logger.info("LogMsg in class <"+ className.getSimpleName() + ">: "+ message);
    }
}