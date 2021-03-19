package com.company.impl;

import com.company.ConsoleHelper;
import java.util.Scanner;

public class ConsHelper  implements ConsoleHelper {
    Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.println("Enter the number of operation you want to do: \n 1 - addition \n 2 - difference \n 3 - multiplication \n 4 - division");
        System.out.println("If you want to exit - enter 0");
    }

    public int getNumbers() {
        System.out.println("Enter the number:");
        return sc.nextInt();
    }

    @Override
    public int getNumberOfMenu() {
        return sc.nextInt();
    }

    @Override
    public void results() {
        int num = 1;
        do {
            menu();
            Calc calc = new Calc();
            num = getNumberOfMenu();
            switch (num) {
                case 0:
                    System.out.println("Goodbye!!");
                    System.exit(0);
                case 1:
                    System.out.println("The result is: " + calc.sum(getNumbers(), getNumbers()));
                    break;
                case 2:
                    System.out.println("The result is: " + calc.dif(getNumbers(), getNumbers()));
                    break;
                case 3:
                    System.out.println("The result is: " + calc.mult(getNumbers(), getNumbers()));
                    break;
                case 4:
                    System.out.println("The result is: " + calc.div(getNumbers(), getNumbers()));
                    break;
                default:
                    System.out.println("Something wrong");
            }
            System.out.println();
        } while(num!=0);
    }
}