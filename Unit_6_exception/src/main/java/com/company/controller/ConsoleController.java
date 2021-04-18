package com.company.controller;

import com.company.data.Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleController {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Operations o = new Operations();

    public void run() {
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("            Welcome to YourCalendar             ");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        do {
            try {
                formats();
                String typeOfOperation = in.readLine();
                String firstInputString = in.readLine();
                String secondInputString = in.readLine();
                Long firstDate = 0L;
                Long secondDate = 0L;
                switch (typeOfOperation) {
                    case "1" -> {
                        firstDate = o.convertingStringToDate(o.convertStringToArray(firstInputString));
                        secondDate = o.convertingStringToDate(o.convertStringToArray(secondInputString));
                    }
                    case "2" -> {
                        firstDate = o.convertingStringToDateSecondDateType(o.convertStringToArray(firstInputString));
                        secondDate = o.convertingStringToDateSecondDateType(o.convertStringToArray(secondInputString));
                    }
                    case "3" -> {
                        firstDate = o.convertingStringToDateThirdDateType(o.convertStringToArray(firstInputString));
                        secondDate = o.convertingStringToDateThirdDateType(o.convertStringToArray(secondInputString));
                    }
                    case "4" -> {
                        firstDate = o.convertingStringToDateForthDateType(o.convertStringToArray(firstInputString));
                        secondDate = o.convertingStringToDateForthDateType(o.convertStringToArray(secondInputString));
                    }
                }
                Long result = o.differenceBetweenDate(firstDate,secondDate);
                o.returnDifferenceInDifFormats(result);
                System.out.println("Finished difference");
            } catch (IOException | NumberFormatException e) {
                System.out.println("Exception");
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void formats() {
        System.out.println("Possible formats for input date: ");
        System.out.println("1. dd/MM/yy (01/01/2021)\n2. m/d/yyyy (04/12/2021)\n3. mmm-d-yy (Jun 4 21)\n4.dd-mmm-yyyy 00:00(4 June 2000 10:00)");
    }
}
