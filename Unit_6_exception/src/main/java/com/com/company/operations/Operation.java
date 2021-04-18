package com.com.company.operations;

import com.company.exception.DateFormatException;

import java.util.Map;
import java.util.TreeMap;

public class Operation {
    ConvertingToMs convertingToMs = new ConvertingToMs();
    static final int SECOND_IN_MILLIS = 1000;
    static final int MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
    static final int HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
    static final int DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;

    public String[] returnStringLikeArray(String s) {
        String newString = s.replaceAll("/", ".").
                replaceAll("-", ".").
                replaceAll(":", ".").
                replaceAll(" ", ".").
                replaceAll("_", " ");
        return newString.split("\\.");
    }

    public Long returnAdditionalData(String s) {
        String[] arrayOfData = returnStringLikeArray(s);
        long amountOfDays = arrayOfData[0].isBlank() ? 0 : Integer.parseInt(arrayOfData[0]);
        long amountOfMonths = arrayOfData[1].isBlank() ? 0 : Integer.parseInt(arrayOfData[1]);
        long amountOfYears = arrayOfData[2].isBlank() ? 0 : Integer.parseInt(arrayOfData[2]);
        long amountOfHours = arrayOfData[3].isBlank() ? 0 : Integer.parseInt(arrayOfData[3]);
        long amountOfMinutes = arrayOfData[4].isBlank() ? 0 : Integer.parseInt(arrayOfData[4]);
        long amountOfSec = arrayOfData[5].isBlank() ? 0 : Integer.parseInt(arrayOfData[5]);
        long amountOfMs = arrayOfData[6].isBlank() ? 0 : Integer.parseInt(arrayOfData[6]);
        if (convertingToMs.checkTheFormat(amountOfDays, amountOfMonths, amountOfYears, amountOfHours, amountOfMinutes, amountOfSec, amountOfMs)) {
            return convertingToMs.convertToMs(amountOfDays, amountOfMonths, amountOfYears, amountOfHours, amountOfMinutes, amountOfSec, amountOfMs);
        } else {
            System.out.println("Data format is wrong. Please check the information and repeat the action");
            return 0L;
        }
    }

    public Long returnDateInMs(String s, String typeOfDate) {
//        try {
            String newString = s.replaceAll("/", ".").
                    replaceAll("-", ".").
                    replaceAll(":", ".").
                    replaceAll(" ", ".").
                    replaceAll("_", " ");
            String[] arrayOfDate = newString.split("\\.");
            long day = 1L;
            long month = 1L;
            long year;
            if (arrayOfDate[2].isBlank()) {
                year = 2021L;
            } else {
                year = Long.parseLong(arrayOfDate[2]);
                if (year <= 21) {
                    year += 2000;
                } else {
                    year += 1900;
                }
            }
            Long hour = arrayOfDate[3].isBlank() ? 0 : Long.parseLong(arrayOfDate[3]);
            Long minute = arrayOfDate[4].isBlank() ? 0 : Long.parseLong(arrayOfDate[4]);
            Long sec = arrayOfDate[5].isBlank() ? 0 : Long.parseLong(arrayOfDate[5]);
            Long ms = arrayOfDate[6].isBlank() ? 0 : Long.parseLong(arrayOfDate[6]);
            switch (typeOfDate) {
                case "1" -> {
                    day = arrayOfDate[0].isBlank() ? 1 : Long.parseLong(arrayOfDate[0]);
                    month = arrayOfDate[1].isBlank() ? 1 : Long.parseLong(arrayOfDate[1]);
                }
                case "2" -> {
                    day = arrayOfDate[1].isBlank() ? 1 : Long.parseLong(arrayOfDate[1]);
                    month = arrayOfDate[0].isBlank() ? 1 : Long.parseLong(arrayOfDate[0]);
                }
                case "3" -> {
                    int curMonth = 0;
                    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                    for (int i = 0; i < 12; i++) {
                        if (arrayOfDate[0].equals(months[i])) {
                            curMonth = i + 1;
                        }
                    }
                    month = arrayOfDate[0].isBlank() ? 1L : curMonth;
                    day = arrayOfDate[1].isBlank() ? 1L : Integer.parseInt(arrayOfDate[1]);
                }
                case "4" -> {
                    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                    int curMonth = 0;
                    for (int i = 0; i < 12; i++) {
                        if (arrayOfDate[i].equals(months[i])) {
                            curMonth = i + 1;
                        }
                    }
                    month = arrayOfDate[0].isBlank() ? 1L : curMonth;
                    day = arrayOfDate[1].isBlank() ? 1L : Integer.parseInt(arrayOfDate[1]);
                }
            }
//        } catch (ArrayIndexOutOfBoundsException | DateFormatException e) {
//            System.out.println("Wrong format. Please, repeat your operation");
//        }
        if (convertingToMs.checkTheFormat(day, month, year, hour, minute, sec, ms)) {
            return convertingToMs.convertToMs(day, month, year, hour, minute, sec, ms);
        } else {
            System.out.println("Data format is wrong. Please check the information and repeat the action");
            return 0L;
        }    }

//    public Long returnFirstDateInMs(String s) {
//        String[] arrayOfDate = returnStringLikeArray(s);
//        int day = arrayOfDate[0].isBlank() ? 1 : Integer.parseInt(arrayOfDate[0]);
//        int month = arrayOfDate[1].isBlank() ? 1 : Integer.parseInt(arrayOfDate[1]);
//        int year;
//        if (arrayOfDate[2].isBlank()) {
//            year = 2021;
//        } else {
//            year = Integer.parseInt(arrayOfDate[2]);
//            if (year <= 21) {
//                year += 2000;
//            } else {
//                year += 1900;
//            }
//        }
//        int hour = arrayOfDate[3].isBlank() ? 0 : Integer.parseInt(arrayOfDate[3]);
//        int minute = arrayOfDate[4].isBlank() ? 0 : Integer.parseInt(arrayOfDate[4]);
//        int sec = arrayOfDate[5].isBlank() ? 0 : Integer.parseInt(arrayOfDate[5]);
//        int ms = arrayOfDate[6].isBlank() ? 0 : Integer.parseInt(arrayOfDate[6]);
//        if (convertingToMs.checkTheFormat(day, month, year, hour, minute, sec, ms)) {
//            return convertingToMs.convertToMs(day, month, year, hour, minute, sec, ms);
//        } else {
//            System.out.println("Data format is wrong. Please check the information and repeat the action");
//            return 0L;
//        }
//    }

//    public Long returnSecondTypeInMs(String s) {
//        String[] arrayOfDate = returnStringLikeArray(s);
//        int month = arrayOfDate[0].isBlank() ? 1 : Integer.parseInt(arrayOfDate[0]);
//        int day = arrayOfDate[1].isBlank() ? 1 : Integer.parseInt(arrayOfDate[1]);
//        int year;
//        if (arrayOfDate[2].isBlank()) {
//            year = 2021;
//        } else {
//            year = Integer.parseInt(arrayOfDate[2]);
//            if (year <= 21) {
//                year += 2000;
//            } else {
//                year += 1900;
//            }
//        }
//        int hour = arrayOfDate[3].isBlank() ? 0 : Integer.parseInt(arrayOfDate[3]);
//        int minute = arrayOfDate[4].isBlank() ? 0 : Integer.parseInt(arrayOfDate[4]);
//        int sec = arrayOfDate[5].isBlank() ? 0 : Integer.parseInt(arrayOfDate[5]);
//        int ms = arrayOfDate[6].isBlank() ? 0 : Integer.parseInt(arrayOfDate[6]);
//        if (convertingToMs.checkTheFormat(day, month, year, hour, minute, sec, ms)) {
//            return convertingToMs.convertToMs(day, month, year, hour, minute, sec, ms);
//        } else {
//            System.out.println("Data format is wrong. Please check the information and repeat the action");
//            return 0L;
//        }
//    }

//    public Long returnThirdTypeInMs(String s) {
//        String[] arrayOfDate = returnStringLikeArray(s);
//        int curMonth = 0;
//        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//        for (int i = 0; i < 12; i++) {
//            if (arrayOfDate[0].equals(months[i])) {
//                curMonth = i + 1;
//            }
//        }
//        int month = arrayOfDate[0].isBlank() ? 1 : curMonth;
//        int day = arrayOfDate[1].isBlank() ? 1 : Integer.parseInt(arrayOfDate[1]);
//        int year;
//        if (arrayOfDate[2].isBlank()) {
//            year = 2021;
//        } else {
//            year = Integer.parseInt(arrayOfDate[2]);
//            if (year <= 21) {
//                year += 2000;
//            } else {
//                year += 1900;
//            }
//        }
//        int hour = arrayOfDate[3].isBlank() ? 0 : Integer.parseInt(arrayOfDate[3]);
//        int minute = arrayOfDate[4].isBlank() ? 0 : Integer.parseInt(arrayOfDate[4]);
//        int sec = arrayOfDate[5].isBlank() ? 0 : Integer.parseInt(arrayOfDate[5]);
//        int ms = arrayOfDate[6].isBlank() ? 0 : Integer.parseInt(arrayOfDate[6]);
//        if (convertingToMs.checkTheFormat(day, month, year, hour, minute, sec, ms)) {
//            return convertingToMs.convertToMs(day, month, year, hour, minute, sec, ms);
//        } else {
//            System.out.println("Data format is wrong. Please check the information and repeat the action");
//            return 0L;
//        }
//    }

//    public Long returnForthTypeInMs(String s) {
//        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//        String[] arrayOfDate = returnStringLikeArray(s);
//        int curMonth = 0;
//        for (int i = 0; i < 12; i++) {
//            if (arrayOfDate[i].equals(months[i])) {
//                curMonth = i + 1;
//            }
//        }
//        int month = arrayOfDate[0].isBlank() ? 1 : curMonth;
//        int day = arrayOfDate[1].isBlank() ? 1 : Integer.parseInt(arrayOfDate[1]);
//        int year;
//        if (arrayOfDate[2].isBlank()) {
//            year = 2021;
//        } else {
//            year = Integer.parseInt(arrayOfDate[2]);
//            if (year <= 21) {
//                year += 2000;
//            } else {
//                year += 1900;
//            }
//        }
//        int hour = arrayOfDate[3].isBlank() ? 0 : Integer.parseInt(arrayOfDate[3]);
//        int minute = arrayOfDate[4].isBlank() ? 0 : Integer.parseInt(arrayOfDate[4]);
//        int sec = arrayOfDate[5].isBlank() ? 0 : Integer.parseInt(arrayOfDate[5]);
//        int ms = arrayOfDate[6].isBlank() ? 0 : Integer.parseInt(arrayOfDate[6]);
//        if (convertingToMs.checkTheFormat(day, month, year, hour, minute, sec, ms)) {
//            return convertingToMs.convertToMs(day, month, year, hour, minute, sec, ms);
//        } else {
//            System.out.println("Data format is wrong. Please check the information and repeat the action");
//            return 0L;
//        }
//    }

//    public void sortedListOfDate(Long inputStringInMs, String inputString) {
//        String firstTestDate = "4/12/20 15:30:3:2";
//        String secondTestDate = "5/1/3 10:_:_:3";
//        String thirdTestDate = "Jun 20 11:35:3:_";
//        String forthTestDate = "6 August 1968 21:12:2:3";
//
//        Long firstTestDateInMs = returnFirstDateInMs(firstTestDate);
//        Long secondTestDateInMs = returnSecondTypeInMs(secondTestDate);
//        Long thirdTestDateInMs = returnThirdTypeInMs(thirdTestDate);
//        Long forthTestDateInMs = returnForthTypeInMs(forthTestDate);
//
//        Map<Long, String> dates = new TreeMap<>();
//
//        dates.put(firstTestDateInMs, firstTestDate);
//        dates.put(secondTestDateInMs, secondTestDate);
//        dates.put(thirdTestDateInMs, thirdTestDate);
//        dates.put(forthTestDateInMs, firstTestDate);
//        dates.put(inputStringInMs, inputString);
//        dates.values();
//    }

}
