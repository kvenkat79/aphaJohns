package com.alpha.johns;

import org.apache.log4j.*;
public class Log {

    private final static Logger LOGGER= Logger.getLogger(Log.class);
    private static PatternLayout layout = new PatternLayout("%dd MMM YYYY HH:mm:ss)%5p %c(1) - %m%n");
    private static FileAppender appender;
    private static ConsoleAppender consoleAppender;
    static {
        consoleAppender=new ConsoleAppender(layout,"System.out");
    }

    public static void info(String name){
        LOGGER.addAppender(consoleAppender);
        LOGGER.setLevel((Level) Level.INFO);
        LOGGER.info(name);
    }
}
