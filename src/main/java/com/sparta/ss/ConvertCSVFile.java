package com.sparta.ss;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {
    public static void createCVSFile(List list) {

        String[] headers = new String[]{"Number of runs", "Open centers", "Full centers", "Trainees currently training", "Trainees on the waiting list"};

        List<String[]> records = new ArrayList<>();
        records.add(headers);

        for (int i = 0; i < list.size(); i ++) {
            records.add((String[]) list.get(i));
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {
            writer.writeAll(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
