package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask1 {
    public static void main(String[] args) {
        System.out.print("Please, enter your string: ");
        String inputString;
        inputString = MyScanner.scanLine();
        int Sum = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);
        int start = 0;
        while (matcher.find(start)) {
            String value = inputString.substring(matcher.start(), matcher.end());
            Sum += Integer.parseInt(value);
            start = matcher.end();
        }
        System.out.println("The sum of all numeric numbers is " + Sum);
    }
}
