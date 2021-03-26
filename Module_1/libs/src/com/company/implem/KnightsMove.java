package com.company.implem;

import com.company.Calculations;

public class KnightsMove {
    ConsHelper ch = new ConsHelper();

    public void menuStart() {
        System.out.println("Введите начальные координаты фигуры: ");
    }

    public void currentPosition(String s) {
        System.out.print("Ваша текущая позиция на доске: " + s);
    }

    public void Knights() {
        menuStart();
        String currentPosition = ch.aString();
        String nextPosition;
        do {
            currentPosition(currentPosition);
            System.out.println("Усли хотите продолжить введите 1, если Вы хотите выйти введите 0: ");
            System.out.print("Ваш выбор: ");
            int choice = ch.number();
            if (choice == 0) {
                break;
            } else {
                System.out.print("Введите координаты: ");
                nextPosition = ch.aString();
                if (Calculations.isPossible(currentPosition.charAt(0),
                        Character.digit(10, (currentPosition.charAt(1))),
                        nextPosition.charAt(0),
                        Character.digit(nextPosition.charAt(1), 10))) {
                    System.out.println("Ход возможен");
                    currentPosition = nextPosition;
                } else {
                    System.out.println("Ход невозможен. Повторите введение хода");
                }
            }
        } while (true);
        System.out.println();
    }
}
