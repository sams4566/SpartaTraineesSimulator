package com.sparta.ss.utilities;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {

    private static final String FILENAME = "src/main/resources/output";
    private static final String CSV_EXT = ".csv";

    public static void createYearCVSFile(List list) {

        String[] headers = new String[]{"Number of runs",
                "Open Training hub centers",
                "Open Tech center centers",
                "Open Bootcamp centers",
                "Closed Training hub centers",
                "Closed Tech center centers",
                "Closed Bootcamp centers",
                "Full Training hub centers",
                "Full Tech center centers",
                "Full Bootcamp centers",
                "Trainees currently training Java",
                "Trainees currently training C#",
                "Trainees currently training Data",
                "Trainees currently training DevOps",
                "Trainees currently training Business",
                "Trainees currently waiting that studied Java",
                "Trainees currently waiting that studied C#",
                "Trainees currently waiting that studied Data",
                "Trainees currently waiting that studied DevOps",
                "Trainees currently waiting that studied Business"};

        List<String[]> records = new ArrayList<>();
        records.add(headers);

        for (int i = 0; i < list.size(); i ++) {
            records.add((String[]) list.get(i));
        }

        //try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {

        createFile(records);

    }

    public static void createMonthCVSFile(List list) {

        String[] headers = new String[]{"Number of runs", "Number of Month",
                "Open Training hub centers",
                "Open Tech center centers",
                "Open Bootcamp centers",
                "Closed Training hub centers",
                "Closed Tech center centers",
                "Closed Bootcamp centers",
                "Full Training hub centers",
                "Full Tech center centers",
                "Full Bootcamp centers",
                "Trainees currently training Java",
                "Trainees currently training C#",
                "Trainees currently training Data",
                "Trainees currently training DevOps",
                "Trainees currently training Business",
                "Trainees currently waiting that studied Java",
                "Trainees currently waiting that studied C#",
                "Trainees currently waiting that studied Data",
                "Trainees currently waiting that studied DevOps",
                "Trainees currently waiting that studied Business"};

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


