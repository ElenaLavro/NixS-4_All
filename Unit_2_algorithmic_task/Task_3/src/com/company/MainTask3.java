package com.company;

import java.util.Arrays;

public class MainTask3  {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        System.out.print("Enter the string: ");
        String inputString = MyScanner.scanLine();
        int length = inputString.length();

        char[] chars = new char[length];
        for(int i = 0; i < length; i++) {
            chars[i] = inputString.charAt(i);
        }
        StringBuilder s = new StringBuilder();
        Arrays.sort(chars);
        for(int i = 0; i < length; i++) {
            if(chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z')
            s.append(chars[i]);
        }
        char ch;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(s.indexOf(String.valueOf(ch)) < i)
                    continue;
                for(int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) == ch)
                        count++;
                }
                System.out.println(ch + " - " + count);
                count = 0;
            }
    }
}