package org.examples.logger.appender;

import org.examples.logger.LogMessage;
import org.examples.logger.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender{
    private final LogFormatter formatter;

     public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }
}
