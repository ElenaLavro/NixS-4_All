package com.company.data;

import com.company.enums.MonthMMM;
import com.company.exception.DateFormatException;

public class Operations{
    private final long msInSecond = 1000;
    private final long secondsInMinute = 60;
    private final long minutesInHour = 60;
    private final long hoursInDay = 24;
    private final long monthsInYear = 12;
    private final long yearsInCentury = 100;
    private final long daysOfYear = 365;

    private final long msToSeconds = 1000;
    private final long msToMinute = msToSeconds * 60;
    private final long msToHour = msToMinute * 60;
    private final long msToDay = msToHour * 24;

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int sec;
    private int ms;

    public String[] convertStringToArray(String s) {
        String newString = s.replaceAll("/", ".").
                replaceAll(":", ".").
                replaceAll("-", ".").
                replaceAll(" ", ".").
                replaceAll("_", " ");
        return newString.split("\\.");
    }

    public Long convertingStringToDate(String[] arrayOfNumbers) throws DateFormatException{
        for (String s:arrayOfNumbers) {
            System.out.println("s = " + s);
        }
        System.out.println("Operations.convertingStringToDate");
        day = arrayOfNumbers[0].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[0]);
        month = arrayOfNumbers[1].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[1]);
        if (arrayOfNumbers[2].isBlank()) {
            year = 2021;
        } else {
            year = Integer.parseInt(arrayOfNumbers[2]);
            year = year < 21 ? year + 2000 : year + 1900;
        }
        hour = arrayOfNumbers[3].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        minute = arrayOfNumbers[4].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        sec = arrayOfNumbers[5].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[4]);
        ms = arrayOfNumbers[6].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[6]);
        if (year > 0 && month > 0 && month <= 12 && day > 0 && hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && sec >= 0 && sec < 60) {
            return convertingDateToMs(year, month, day, hour, minute, sec, ms);
        } else {
            throw new DateFormatException("Invalid date format. Please, repeat you operation again");
        }
    }

    public Long convertingStringToDateSecondDateType(String[] arrayOfNumbers) throws DateFormatException {
        System.out.println("Operations.convertingStringToDateSecondDateType");
        day = arrayOfNumbers[1].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[1]);
        month = arrayOfNumbers[0].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[0]);
        if (arrayOfNumbers[2].isBlank()) {
            year = 2021;
        } else {
            year = Integer.parseInt(arrayOfNumbers[2]);
            year = year < 21 ? year + 2000 : year + 1900;
        }
        hour = arrayOfNumbers[3].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        minute = arrayOfNumbers[4].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        sec = arrayOfNumbers[5].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[4]);
        ms = arrayOfNumbers[6].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[6]);
        if (year > 0 && month > 0 && month <= 12 && day > 0 && hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && sec >= 0 && sec < 60) {
            return convertingDateToMs(year, month, day, hour, minute, sec, ms);
        } else {
            throw new DateFormatException("Invalid date format. Please, repeat you operation again");
        }
    }

    public Long convertingStringToDateThirdDateType(String[] arrayOfNumbers) throws DateFormatException {

//        for (int i = 0; i < 12; i++) {
//            if(arrayOfNumbers[0].equals(MonthMMM.values()[i]) {
//
//            }
//        }
        day = arrayOfNumbers[1].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[1]);
        if (arrayOfNumbers[2].isBlank()) {
            year = 2021;
        } else {
            year = Integer.parseInt(arrayOfNumbers[2]);
            year = year < 21 ? year + 2000 : year + 1900;
        }
        minute = arrayOfNumbers[4].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        sec = arrayOfNumbers[5].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[4]);
        ms = arrayOfNumbers[6].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[6]);
        if (year > 0 && month > 0 && month <= 12 && day > 0 && hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && sec >= 0 && sec < 60) {
            return convertingDateToMs(year, month, day, hour, minute, sec, ms);
        } else {
            throw new DateFormatException("Invalid date format. Please, repeat you operation again");
        }
    }

    public Long convertingStringToDateForthDateType(String[] arrayOfNumbers) throws DateFormatException {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            if (arrayOfNumbers[0].equals(months[i])) {
                month = i + 1;
            }
        }
        day = arrayOfNumbers[1].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[1]);
        year = arrayOfNumbers[2].isBlank() ? 1 : Integer.parseInt(arrayOfNumbers[2]);
        minute = arrayOfNumbers[4].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[3]);
        sec = arrayOfNumbers[5].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[4]);
        ms = arrayOfNumbers[6].isBlank() ? 0 : Integer.parseInt(arrayOfNumbers[6]);
        if (year > 0 && month > 0 && month <= 12 && day > 0 && hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && sec >= 0 && sec < 60) {
            return convertingDateToMs(year, month, day, hour, minute, sec, ms);
        } else {
            throw new DateFormatException("Invalid date format. Please, repeat you operation again");
        }
    }


    public Long convertingDateToMs(int year, int month, int day, int hour, int minute, int sec, int ms) {
        System.out.println("Operations.convertingDateToMs");
        int q = 0;
        for (int i = 0; i <= year; i++) {
            if (isLeapYear(i)) {
                q++;
            }
        }
        month += year * monthsInYear;
        day += month * daysOfYear + q;
        hour += day * hoursInDay;
        minute += hour * minutesInHour;
        sec += minute * secondsInMinute;
        return (sec * msInSecond + ms);
    }

    public Long differenceBetweenDate(Long firstDate, Long secondDate) {
        System.out.println("Operations.differenceBetweenDate");
        return firstDate > secondDate ? firstDate - secondDate : secondDate - firstDate;
    }

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public void returnDifferenceInDifFormats(Long difference) {
        System.out.println("Operations.returnDifferenceInDifFormats");
        long ms = difference % msInSecond;
        long sec = difference / msToDay % secondsInMinute;
        long minute = difference / msToMinute % minutesInHour;
        long hour = difference / msToHour % hoursInDay;
        long day = difference / msToDay;
        long month = 0;
        int[] normalYear = {31, 30, 28, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 30, 29, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("before while");
//        while (day > 0) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 12; j++) {
//                    if(day <=0) {break;}
//                    if (day - normalYear[j] >= 0) {
//                        day -= normalYear[j];
//                        month++;
//                    } else {
//                        break;
//                    }
//                }
//            }
//            for (int i = 0; i < 12; i++) {
//                if(day<=0) {break;}
//                if (day - leapYear[i] >= 0) {
//                    day -= leapYear[i];
//                    month++;
//                } else {
//                    break;
//                }
//            }
//        }
        System.out.println("after while");
        long years = difference / monthsInYear % yearsInCentury;
        long centuries = difference / yearsInCentury;
        System.out.println(returningTheResult(centuries, years, month, day, hour, minute, sec, ms));
    }

    public String returningTheResult(long century, long year, long month, long day, long hour, long minute, long sec, long ms) {
        System.out.println("Operations.returningTheResult");
        return "The difference in century is equal " + century + ", in years " + year + ", in months " + month + ", in days " +
                day + ", in hours " + hour + ", in minutes " + minute + ", in seconds " + sec + ", in milliseconds " + ms;
    }
}
