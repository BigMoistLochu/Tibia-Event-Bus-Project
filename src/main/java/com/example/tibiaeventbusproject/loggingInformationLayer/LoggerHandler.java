package com.example.tibiaeventbusproject.loggingInformationLayer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
        ZonedDateTime czas = record.getInstant().atZone(ZoneId.of("Europe/Warsaw"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sformatowanyCzas = czas.format(formatter);
        System.out.println("Czas w Polsce: " + sformatowanyCzas);
        //zapisywanie do pliku
        //wiadomosc chcesz zeby wygladala nastepujaco, Data,klasa/wiadomosc
        String logAll = sformatowanyCzas+" "+logName+" "+logEntry;
        LoggerWriteToFile.appendLogsInformationToFile(logAll);
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
