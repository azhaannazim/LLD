package org.examples.logger.appender;

import org.examples.logger.LogMessage;

public interface LogAppender {//factory method
    void append(LogMessage message);
}
