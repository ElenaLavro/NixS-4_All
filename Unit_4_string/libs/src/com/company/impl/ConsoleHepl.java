package com.company.impl;

import com.company.ConsoleHelper;
import java.util.Scanner;

public class ConsoleHepl implements ConsoleHelper {
    Scanner sc = new Scanner(System.in);
    @Override
    public int getNumberOfMenu() {
        System.out.print("You choice is: ");
        return sc.nextInt();
    }
    @Override
    public void menu() {
        System.out.println("Choose the task you want to do: \n 1 - normal reverse!  \n 2 - Reverse of the chosen string! \n 3 - All of them ");
        System.out.println("If you want to exit - enter 0");
    }
    @Override
    public String getInputString() {
        System.out.print("Enter the string you want to reverse: ");
        return sc.nextLine();
    }
    @Override
    public void results() {
        int num = 1;
        do {
            menu();
            ReverseStr reverseStr = new ReverseStr();
            num = getNumberOfMenu();
            String newString = sc.nextLine();
            switch (num) {
                case 0 -> {
                    System.out.println("Goodbye!!");
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("Enter the string: ");
                    reverseStr.normalReverse(sc.nextLine());
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Enter the first String:");
                    String firstString = sc.nextLine();
                    System.out.println("Enter the second String: ");
                    String secondString = sc.nextLine();
                    if(!firstString.contains(secondString)) {
                        System.out.println("String don`t contain entered substring");
                        break;
                    }
                    System.out.println("The result is: " + reverseStr.reverseOfChosenString(firstString, secondString));
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Enter the String: ");
                    String s = sc.nextLine();
                    System.out.println("Enter the first index: ");
                    int a = sc.nextInt();
                    System.out.println("Enter the second index: ");
                    int b = sc.nextInt();
                    if(b > s.length() || a < s.length()) {
                        System.out.println("You input data is wrong. Please repeat all again!");
                        break;
                    }
                    System.out.println("Your final string after reverse is: ");
                    reverseStr.fullReverse(s, a, b);
                    System.out.println();
                }
                default -> System.out.println("Something wrong");
            }
            System.out.println();
        } while(true);
    }



}
