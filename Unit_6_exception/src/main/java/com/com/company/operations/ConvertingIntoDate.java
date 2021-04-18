package com.com.company.operations;

public class ConvertingIntoDate {
    public void convertIntoDate(Long result) {
        long ms = (result % 1000) / 100;
        long seconds = (result / 1000) % 60;
        long minutes = (result / (1000 * 60)) % 60;
        long hours = (result / (1000 * 60 * 60)) % 24;

//        hours = (hours < 10) ? Long.parseLong("0" + hours) : hours;
//        minutes = minutes<10 ? Long.parseLong("0"+ minutes):minutes;
//        seconds = seconds<10 ? Long.parseLong("0"+seconds):seconds;
        long days = 0;
        int year = 0;
        System.out.println("Years =" + year);
        int month = 0;
        int[] normalYear = {31, 30, 28, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 30, 29, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean status = true;
        while (status) {
            if (days <= 0) {
                status = false;
                break;
            } else {
                for (int i = 0; i < 3 && status; i++) {
                    for (int j = 0; j < 12 && status; j++) {
                        if (days - normalYear[j] >= 0) {
                            days -= normalYear[j];
                        } else {
                            month = j + 1;
                            break;
                        }
                    }
                    year++;
                }
                for (int i = 0; i < 12 && status; i++) {
                    if (days - leapYear[i] >= 0) {
                        days -= leapYear[i];
                    } else {
                        month = i + 1;
                        break;
                    }
                }
                year++;
            }
        }
        int century = (int) (days / 100);
        System.out.println("The date. Century - { " + century + " }, year { " + year + " }, month { " +
                month + " }, hours { " + hours + " }, minutes { " + minutes + " }, seconds { " + seconds + " }");

    }
}
