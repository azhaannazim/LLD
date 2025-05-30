package org.examples.logger;

import org.examples.logger.appender.ConsoleAppender;
import org.examples.logger.formatter.DefaultFormatter;

public class Logger {
    public static final Logger instance = new Logger(); //eager initialization
    private LogConfig config;

    private Logger() {
        config = new LogConfig(LogLevel.INFO, new ConsoleAppender(new DefaultFormatter()));
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setConfig(LogConfig config) {
        this.config = config;
    }

    public void log(LogLevel level, String message) {
        if (level.getPriority() >= config.getLevel().getPriority()) {
            LogMessage logMessage = new LogMessage(level, message);
            config.getAppender().append(logMessage);
        }
    }
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}