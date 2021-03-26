package com.company.implem;

import java.util.Stack;

public class ValidString {
    ConsHelper ch = new ConsHelper();

    public void isValid() {
        System.out.print("Введите входную строку: ");
        String inputString = ch.aString();
        boolean isVal = true;
        Stack<Character> validStrings = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            switch (ch) {
                case '(' -> validStrings.push('(');
                case '[' -> validStrings.push('[');
                case '{' -> validStrings.push('{');
                case ')' -> {
                    char top = validStrings.pop();
                    if (top != '(') {
                        isVal = false;
                    }
                }
                case ']' -> {
                    char top = validStrings.pop();
                    if (top != '[') {
                        isVal = false;
                    }
                }
                case '}' -> {
                    char top = validStrings.pop();
                    if (top != '{') {
                        isVal = false;
                    }
                }
            }
        }
        if (!validStrings.isEmpty()) {
            isVal = false;
        }
        if (isVal) {
            System.out.println("Допустимая строка");
        } else {
            System.out.println("Недопустимая строка");
        }
    }
}
