package org.examples.logger;

import org.examples.logger.appender.LogAppender;

public class LogConfig {
    private LogLevel level;
    private LogAppender appender; //factory method

    public LogConfig(LogLevel level, LogAppender appender) {
        this.level = level;
        this.appender = appender;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public LogAppender getAppender() {
        return appender;
    }

    public void setAppender(LogAppender appender) {
        this.appender = appender;
    }
}
