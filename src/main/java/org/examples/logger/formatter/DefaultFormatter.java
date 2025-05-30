package org.examples.logger.formatter;

import org.examples.logger.LogMessage;

public class DefaultFormatter implements LogFormatter {
    @Override
    public String format(LogMessage msg) {
        return String.format("[%s] [%s] [%s] %s",
                msg.getTimeStamp(), msg.getThreadName(), msg.getLevel(), msg.getMessage());
    }
}
