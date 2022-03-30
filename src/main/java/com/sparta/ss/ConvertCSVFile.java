package com.sparta.ss;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {

    private static final String FILENAME = "src/main/resources/output";
    private static final String CSV_EXT = ".csv";

    public static void createCVSFile(List list) {

        String[] headers = new String[]{"Number of runs", "Open centers", "Full centers", "Trainees currently training", "Trainees on the waiting list"};

        List<String[]> records = new ArrayList<>();
        records.add(headers);

        for (int i = 0; i < list.size(); i ++) {
            records.add((String[]) list.get(i));
        }

        //try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {

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


