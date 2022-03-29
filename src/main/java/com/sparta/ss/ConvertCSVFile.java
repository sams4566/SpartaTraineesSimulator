package com.sparta.ss;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVFile {
    public static void createCVSFile(int openCenters, int fullCenters, int traineesInTraining, int waitingList) {

        String[] headers = new String[]{"Open centers", "Full centers", "Trainees currently training", "Trainees on the waiting list"};
        String[] formattedData = {String.valueOf(openCenters), String.valueOf(fullCenters), String.valueOf(traineesInTraining), String.valueOf(waitingList)};

        List<String[]> records = new ArrayList<>();
        records.add(headers);
        records.add(formattedData);

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"))) {
            writer.writeAll(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
