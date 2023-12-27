package com.example.tibiaeventbusproject.loggingInformationLayer;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LoggerHandler extends Handler {



    @Override
    public void publish(LogRecord record) {

        String logEntry = record.getMessage();
        String logName = record.getLoggerName();

        // Tutaj możesz wykonać dowolne operacje na przechwyconym logu, np. zapis do pliku, baza danych, wysłanie powiadomienia, itp.
        System.out.println("Przechwycono log: " + logEntry);
        System.out.println("Przechwycono log: "+ logName);
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
