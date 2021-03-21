package com.company;

import java.util.Scanner;
public class MyScanner {
    static Scanner scan = new Scanner(System.in);

    public static String scan() {
        return scan.next();
    }
    public static String scanLine() {
        return scan.nextLine();
    }
    public static int scanInt()
    {
        return  scan.nextInt();
    }
}
