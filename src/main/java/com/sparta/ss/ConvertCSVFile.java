package com.sparta.ss;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {
    public static void convert() {
        List<String[]> csvData = createCsvDataSimple();

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> createCsvDataSimple() {
        String[] header = {"run times", "open centres", "full centres", "trainees currently training", "trainees on the waiting list"};
        String[] record = {"1", "1", "0", "55", "0"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record);

        return list;
    }
}
