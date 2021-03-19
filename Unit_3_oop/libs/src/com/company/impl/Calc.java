package com.company.impl;
import com.company.Calculator;

public class Calc implements Calculator{
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int dif(int a, int b) {
        return a-b;
    }

    @Override
    public int mult(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        if(b!=0) {
            return a / b;
        } else {
            System.out.println("Exception!! you cannot divide by zero ");
            return 0;
        }
    }
}
