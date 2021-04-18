package com.com.company.controller;

import com.com.company.formatHandlers.Adding;
import com.com.company.formatHandlers.Difference;
import com.com.company.formatHandlers.Subtract;
import com.com.company.operations.ConvertingIntoBaseDate;
import com.com.company.operations.ConvertingIntoDate;
import com.com.company.operations.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    ConvertingIntoBaseDate intoBaseDate = new ConvertingIntoBaseDate();
    Operation c = new Operation();
    ConvertingIntoDate converting = new ConvertingIntoDate();

    public void menu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Difference between 2 dates");
        System.out.println("2. Adding to date");
        System.out.println("3. Subtract from date");
        System.out.println("4. Compare dates descending and ascending ");
        System.out.println("0. Exit\n");
    }

    public void typeOfDate() {
        System.out.println("~~~~~~~~~~~~~~~Select date format~~~~~~~~~~~~~~~");
        System.out.println("1 ~ dd/MM/yy");
        System.out.println("2 ~ M/d/yyyy");
        System.out.println("3 ~ MMM-d-yy");
        System.out.println("4 ~ dd-MMM-yyyy");
        System.out.println("The default format for input time is HH:mm:ss.SSS");
        System.out.println("If you do not want to enter some value,please replace it with '_'\n Example: _/_/_ _:_:_:_");
        System.out.print("Your choice is : ");
    }

    private void messageForEnteringValues() {
        System.out.println("Please, enter the value you want to add to data");
        System.out.println("If you want to skip some period, please enter '_' instead of it");
        System.out.println("Example: If you want just to add minutes: _/_/_ _:14:_:_ \n");
    }

    public void run() {
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("            Welcome to YourCalendar             ");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-\n");
        String position;
        try {
            do {
                menu();
                System.out.print("Your choice: ");
                position = in.readLine();
                switch (position) {
                    case "0": {
                        System.out.println("~~~Goodbye~~~");
                        System.exit(0);
                    }
                    case "1": {
                        try {
                            typeOfDate();
                            String numberIfTypeOfDate = in.readLine();
                            Difference difference = new Difference();
                            System.out.println("First date: ");
                            String firstInputString = in.readLine();
                            System.out.println("Second date: ");
                            String secondInputString = in.readLine();
                            Long firstDate = c.returnDateInMs(firstInputString,numberIfTypeOfDate);
                            Long secondDate = c.returnDateInMs(secondInputString,numberIfTypeOfDate);
                            System.out.println("firstDate = " + firstDate);
                            System.out.println("SecondDate = " + secondDate);
                            Long result = difference.differenceBetweenTwoDates(firstDate, secondDate);
                            converting.convertIntoDate(result);
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Input format of date is wrong. Please, repeat you action\n");
                        }
                        break;
                    }
                    case "2": {
                        try {
                            typeOfDate();
                            Adding adding = new Adding();
                            String typeOfFormat = in.readLine();
                            System.out.println("Please, enter the date");
                            String inputString = in.readLine();
                            Long dateInMS = c.returnDateInMs(inputString,typeOfFormat);

                            messageForEnteringValues();
                            String addingValue = in.readLine();
                            Long addingValueInMs = c.returnAdditionalData(addingValue);
                            intoBaseDate.resultOfTheOperations(adding.addingParToDate(dateInMS, addingValueInMs));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Input format of date is wrong. Please, repeat you action\n");
                        }
                        break;
                    }
                    case "3": {
                        try {
                            Subtract subtract = new Subtract();
                            typeOfDate();
                            String typeOfFormat = in.readLine();
                            System.out.println("Please, enter the date");
                            String inputString = in.readLine();
                            Long dateInMs = c.returnDateInMs(inputString,typeOfFormat);

                            messageForEnteringValues();
                            String valueOfTheSubtractDate = in.readLine();
                            Long subtractValueToMS = c.returnAdditionalData(valueOfTheSubtractDate);
                            intoBaseDate.resultOfTheOperations(subtract.subtractParFromDate(dateInMs, subtractValueToMS));

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Input format of date is wrong. Please, repeat you action\n");
                        }
                    }
                    case "4": {
                        try {
                            typeOfDate();
                            String typeOfFormat = in.readLine();
                            System.out.println("Please, enter the date");
                            String inputString = in.readLine();
                            Long dateInMs = c.returnDateInMs(inputString,typeOfFormat);

//                            c.sortedListOfDate(dateInMs, inputString);

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Input format of date is wrong. Please, repeat you action\n");
                        }

                    }
                    default:
                        System.out.println("Wrong number, please repeat the choice\n");
                }
            } while (true);
        } catch (IOException | NumberFormatException Exception) {
            System.out.println("Invalid value. Please, repeat operation");
        }
    }
}
