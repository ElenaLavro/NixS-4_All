package com.com.company.formatHandlers;

public class Difference {
    public Long differenceBetweenTwoDates(Long firstNumber, Long secondNumber) {
        return firstNumber >= secondNumber ? firstNumber - secondNumber : secondNumber - firstNumber;
    }
}
