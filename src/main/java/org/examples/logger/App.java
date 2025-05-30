package org.examples.logger;

import org.examples.logger.appender.FileAppender;
import org.examples.logger.formatter.DefaultFormatter;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Logging with default configuration
        logger.info("This is an information message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

        // Changing log level and appender
        LogConfig config = new LogConfig(LogLevel.DEBUG, new FileAppender("app.log", new DefaultFormatter()));
        logger.setConfig(config);

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}
