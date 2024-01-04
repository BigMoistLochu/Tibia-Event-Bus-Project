package com.example.tibiaeventbusproject.loggingInformationLayer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LoggerHandler extends Handler {

    @Override
    public void publish(LogRecord record) {

        ZonedDateTime czas = record.getInstant().atZone(ZoneId.of("Europe/Warsaw"));
        String sformatowanyCzas = czas.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        StringBuilder logBuilder = new StringBuilder();

        logBuilder.append(sformatowanyCzas)
                .append(",")
                .append(record.getLoggerName())
                .append(",")
                .append(record.getMessage());

        LoggerWriteToFile.appendLogsInformationToFile(logBuilder.toString());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
