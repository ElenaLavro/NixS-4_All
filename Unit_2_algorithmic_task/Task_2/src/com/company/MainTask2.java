package com.company;

public class MainTask2 {
    public static void main(String[] args) {
        System.out.print("Please, enter the number of lesson you need: ");
        MyScanner scanner = new MyScanner();
        int numberOfLesson = MyScanner.scanInt();
        switch (numberOfLesson) {
            case 1 -> System.out.println("The end of lesson is  9 : 45");
            case 2 -> System.out.println("The end of lesson is  10 : 35");
            case 3 -> System.out.println("The end of lesson is  11 : 35");
            case 4 -> System.out.println("The end of lesson is  12 : 25");
            case 5 -> System.out.println("The end of lesson is  13 : 25");
            case 6 -> System.out.println("The end of lesson is  14 : 15");
            case 7 -> System.out.println("The end of lesson is  15 : 15");
            case 8 -> System.out.println("The end of lesson is  16 : 05");
            case 9 -> System.out.println("The end of lesson is  17 : 05");
            case 10 -> System.out.println("The end of lesson is  17 : 45");
        }
    }
}
