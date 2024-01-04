package com.example.tibiaeventbusproject.loggingInformationLayer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerWriteToFile {

    private static String filePath = "loggs.txt";

    protected static void appendLogsInformationToFile(String logMessage)
    {
        try {
            // Tworzenie obiektu FileWriter z wybraną ścieżką pliku w trybie dopisywania
            FileWriter fileWriter = new FileWriter(filePath, true);
            // Tworzenie obiektu BufferedWriter dla optymalnego zapisu do pliku
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            bufferedWriter.write(logMessage); // Dopisywanie tekstu do pliku
            bufferedWriter.newLine(); // Dodanie nowej linii po dopisaniu tekstu

            // Zamykanie strumieni
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Tekst został dopisany do pliku.");

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas dopisywania do pliku: " + e.getMessage());
        }
    }








}
