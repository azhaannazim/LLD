package org.examples.logger.appender;

import org.examples.logger.LogMessage;
import org.examples.logger.formatter.LogFormatter;

import java.io.FileWriter;

public class FileAppender implements LogAppender{
    private final LogFormatter formatter;
    private FileWriter fileWriter;

    public FileAppender(String filePath ,LogFormatter formatter) {
        this.formatter = formatter;
        try {
            this.fileWriter = new FileWriter(filePath ,true);
        }
        catch (Exception e){
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }

    @Override
    public void append(LogMessage message) {
        try{
            fileWriter.write(formatter.format(message) + "\n");
            fileWriter.flush();
        }
        catch (Exception e){
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }
}
