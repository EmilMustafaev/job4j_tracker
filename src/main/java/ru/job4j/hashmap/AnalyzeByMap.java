package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result;
        double totalScore = 0D;
        int countSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                countSubjects++;
            }
        }
        result = totalScore / countSubjects;
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0D;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            result.add(new Label(pupil.name(), totalScore / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> totalScores = new LinkedHashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores.merge(subject.name(), (double) subject.score(), Double::sum);
                counts.merge(subject.name(), 1, Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (String subject : totalScores.keySet()) {
            result.add(new Label(subject, totalScores.get(subject) / counts.get(subject)));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0D;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            result.add(new Label(pupil.name(), totalScore));
        }
        return Collections.max(result);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> result = new ArrayList<>();
        for (String subject : totalScores.keySet()) {
            result.add(new Label(subject, totalScores.get(subject)));
        }
        return Collections.max(result);
    }
}
