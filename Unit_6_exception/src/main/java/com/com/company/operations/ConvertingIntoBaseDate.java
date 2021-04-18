package com.com.company.operations;

public class ConvertingIntoBaseDate {
    public void resultOfTheOperations(Long result) {
        long sec = result / 1000;
        System.out.println("The result in seconds is equal : " + sec);
        long min = result / (1000 * 60);
        System.out.println("The result in minutes is equal : " + min);
        long hour = result / (1000 * 60 * 60);
        System.out.println("The result in hours is equal :  " + hour);
        long day = result / (1000 * 60 * 60 * 24);
        System.out.println("The result in days is equal : " + day);
        long month = result / (1000L * 60 * 60 * 24 * 30);
        System.out.println("The result in months is equal : " + month);
        long year = result / (1000L * 60 * 60 * 24 * 365);
        System.out.println("The result in years is equal : " + year);
    }


}
