package com.austinzeller.reportcardclassapp;

import java.util.ArrayList;

public class ReportCard {

    private ArrayList<Program> bPrograms;
    private double bGPA = determineGPA(bPrograms);

    ReportCard(ArrayList<Program> programs) {
        bPrograms = programs;
    }

    private double determineGPA(ArrayList<Program> programs) {
        double GPA = 0d;
        for (Program program : programs) {
            GPA += program.getGradeOnTenPointScale();
        }
        return GPA / programs.size();
    }

    public String toString(){
        String message = "Report Card: ";
        for (Program program : bPrograms){
            message += "\n" + program.toString();
        }
        message += "\nSemester GPA: " + bGPA;
        return message;
    }

    private class Program {
        private String bProgramTitle;
        private double bFinalRatioScore;
        private char bCharacterGrade = convertToCharacterGrade(bFinalRatioScore);

        Program(String programTitle, double finalratioScore) {
            bProgramTitle = programTitle;
            bFinalRatioScore = finalratioScore;
        }

        public char getCharacterGrade() {
            return bCharacterGrade;
        }
        public String getProgramTitle() {
            return bProgramTitle;
        }

        public void setRatioScore(double ratioScore) {
            bFinalRatioScore = ratioScore;
        }

        public void setProgramTitle(String programTitle) {
            bProgramTitle = programTitle;
        }

        public double getFinalRatioScore() {
            return bFinalRatioScore;
        }

        double getGradeOnTenPointScale() {
            return convertToCharacterGrade(bCharacterGrade);
        }

        char convertToCharacterGrade(double finalRatioScore) {
            if (finalRatioScore > 90d) {
                return 'A';
            }
            if (finalRatioScore > 80d) {
                return 'B';
            }
            if (finalRatioScore > 70d) {
                return 'C';
            }
            if (finalRatioScore > 60d) {
                return 'D';
            }
            return 'F';
        }

        public double toTenPointScale(char grade) {
            switch (grade) {
                case 'A':
                    return 100d;
                case 'B':
                    return 90d;
                case 'C':
                    return 80d;
                case 'D':
                    return 70d;
                default:
                    return 0d;
            }
        }
        public String toString(){
            return bProgramTitle + ":     " + bCharacterGrade;}
    }
}
