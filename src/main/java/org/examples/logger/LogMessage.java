package org.examples.logger;

import java.time.Instant;
import java.util.Date;

public class LogMessage {
    private LogLevel level;
    private String message;
    private long timeStamp;
    private String threadName;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timeStamp = System.currentTimeMillis(); //new Date().getTime();
        this.threadName = Thread.currentThread().getName();
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public String toString() {
        return String.format("[%s] %d [%s] - %s",
                level,
                timeStamp,
                threadName,
                message);
    }
}
