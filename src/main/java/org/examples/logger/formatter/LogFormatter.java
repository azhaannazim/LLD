package org.examples.logger.formatter;

import org.examples.logger.LogMessage;

public interface LogFormatter {//factory method
    String format(LogMessage message);
}
