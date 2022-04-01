package com.sparta.ss.utilities;

import com.sparta.ss.trainee.TraineeBench;
import com.sparta.ss.trainee.TraineeManager;
import com.sparta.ss.trainingcentre.TrainingCenterManager;

public class CSVFormatter {

    public static String[] getRecordsForMonth(int i, int j) {
        String records[] = {String.valueOf(i + 1), String.valueOf(j),
                String.valueOf(TrainingCenterManager.getOpenTrainingHubCount()),
                String.valueOf(TrainingCenterManager.getOpenTechCentersCount()),
                String.valueOf(TrainingCenterManager.getOpenBootCampCount()),
                String.valueOf(TrainingCenterManager.getClosedTrainingHubs()),
                String.valueOf(TrainingCenterManager.getClosedTechCentres()),
                String.valueOf(TrainingCenterManager.getClosedBootcampCentres()),
                String.valueOf(TrainingCenterManager.getFullTrainingHubCount()),
                String.valueOf(TrainingCenterManager.getFullTechCenterCount()),
                String.valueOf(TrainingCenterManager.getFullBootCampCount()),
                String.valueOf(TrainingCenterManager.getTraineesInTraining("Java")),
                String.valueOf(TrainingCenterManager.getTraineesInTraining("Business")),
                String.valueOf(TrainingCenterManager.getTraineesInTraining("DevOps")),
                String.valueOf(TrainingCenterManager.getTraineesInTraining("Data")),
                String.valueOf(TrainingCenterManager.getTraineesInTraining("C#")),
                String.valueOf(TraineeManager.getTraineeWaitingCount("Java")),
                String.valueOf(TraineeManager.getTraineeWaitingCount("Business")),
                String.valueOf(TraineeManager.getTraineeWaitingCount("DevOps")),
                String.valueOf(TraineeManager.getTraineeWaitingCount("Data")),
                String.valueOf(TraineeManager.getTraineeWaitingCount("C#")),
                String.valueOf(TraineeBench.benchTrainees.size())};
        return records;
    }

        public static String[] getRecordsForYear ( int i){
            String records[] = {String.valueOf(i + 1),
                    String.valueOf(TrainingCenterManager.getOpenTrainingHubCount()),
                    String.valueOf(TrainingCenterManager.getOpenTechCentersCount()),
                    String.valueOf(TrainingCenterManager.getOpenBootCampCount()),
                    String.valueOf(TrainingCenterManager.getFullTrainingHubCount()),
                    String.valueOf(TrainingCenterManager.getFullTechCenterCount()),
                    String.valueOf(TrainingCenterManager.getFullBootCampCount()),
                    String.valueOf(TrainingCenterManager.getClosedTrainingHubs()),
                    String.valueOf(TrainingCenterManager.getClosedTechCentres()),
                    String.valueOf(TrainingCenterManager.getClosedBootcampCentres()),
                    String.valueOf(TraineeManager.getTraineeWaitingCount("Java")),
                    String.valueOf(TraineeManager.getTraineeWaitingCount("Business")),
                    String.valueOf(TraineeManager.getTraineeWaitingCount("DevOps")),
                    String.valueOf(TraineeManager.getTraineeWaitingCount("Data")),
                    String.valueOf(TraineeManager.getTraineeWaitingCount("C#")),
                    String.valueOf(TrainingCenterManager.getTraineesInTraining("Java")),
                    String.valueOf(TrainingCenterManager.getTraineesInTraining("Business")),
                    String.valueOf(TrainingCenterManager.getTraineesInTraining("DevOps")),
                    String.valueOf(TrainingCenterManager.getTraineesInTraining("Data")),
                    String.valueOf(TrainingCenterManager.getTraineesInTraining("C#")),
                    String.valueOf(TraineeBench.benchTrainees.size())};
            return records;

        }
    }

