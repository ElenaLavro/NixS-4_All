package com.company.impl;

import com.company.ReverseString;

public class ReverseStr implements ReverseString {
    @Override
    public String normalReverse(String s) {
        char[] newStringInChar = s.toCharArray();
        for (int i = newStringInChar.length-1; i >= 0; i--)
            System.out.print(newStringInChar[i]);
        return s;
    }

    @Override
    public String reverseOfChosenString(String s, String subString) {
        char[] newStringInChar = subString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = newStringInChar.length -1; i >= 0; i--)
            stringBuilder.append(newStringInChar[i]);
        return s.replaceAll(subString, stringBuilder.toString());
    }

    @Override
    public void fullReverse(String s, int a, int b) {
        int q = -1;
        String newString;
        String[] newArray = s.split(" ");
        for (String value : newArray) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < value.length(); j++) {
                q++;
                if (q >= a && q <= b) {
                    stringBuilder.append(value.charAt(j));
                }
            }
            q++;
            newString = reverseOfChosenString(value, stringBuilder.toString());
            System.out.print(newString + " ");
        }
    }

}
