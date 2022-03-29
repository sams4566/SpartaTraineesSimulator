package com.sparta.ss;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {

    private static final String FILENAME = "src/main/resources/output";
    private static final String CSV_EXT = ".csv";

    public static void createCVSFile(int openCenters, int fullCenters, int traineesInTraining, int waitingList) {

        String[] headers = new String[]{"Open centers", "Full centers", "Trainees currently training", "Trainees on the waiting list"};
        String[] formattedData = {String.valueOf(openCenters), String.valueOf(fullCenters), String.valueOf(traineesInTraining), String.valueOf(waitingList)};

        List<String[]> records = new ArrayList<>();
        records.add(headers);
        records.add(formattedData);

        createFile(records);

    }

    public static boolean checkFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static void createFile(List<String[]> records) {
        int numFile = 1;
        String fileName = FILENAME + numFile + CSV_EXT;

        while (checkFileExists(fileName)) {
            numFile++;
            fileName = FILENAME + numFile + CSV_EXT;
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


