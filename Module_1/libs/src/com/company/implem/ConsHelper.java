package com.company.implem;

import com.company.ConsoleHelper;

import java.util.HashSet;
import java.util.Scanner;

public class ConsHelper implements ConsoleHelper {
    Scanner sc = new Scanner(System.in);

    @Override
    public int number() {
        return sc.nextInt();
    }

    public String aString() {
        return sc.next();
    }

    @Override
    public int arrayOfInts() {
        System.out.println("Введите размер массива:");
        int size = number();
        HashSet<Integer> hs = new HashSet<>(size);
        System.out.print("Введите массив: ");
        int i = 0;
        while (i < size) {
            hs.add(number());
            i++;
        }
        return hs.size();
    }

    @Override
    public void allMenu() {
        System.out.println("Введите номер уровня задач: ");
        System.out.println("1 - Уровень 1(Количество уникальных чисел, Ход коня, Площадь треугольника)");
        System.out.println("2 - Уровень 2(Допустимая строка)");
        System.out.println("3 - Уровень 3(Игра в жизнь)");
        System.out.println("0 - Выход");

    }

    @Override
    public void result() {
        do {
            allMenu();
            switch (number()) {
                case 0 -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                case 1 -> {
                    menuLevel1();
                    switch (number()) {
                        case 0 -> {
                            System.out.println("Goodbye");
                            System.exit(0);
                        }
                        case 1 -> System.out.println("Количество уникальных символов = " + arrayOfInts());
                        case 2 -> {
                            KnightsMove knightsMove = new KnightsMove();
                            knightsMove.Knights();
                        }
                        case 3 -> {
                            AreaOfTriangle areaOfTriangle = new AreaOfTriangle();
                            areaOfTriangle.Area();
                        }
                        default -> System.out.println("Something wrong");
                    }
                }
                case 2 -> {
                    ValidString validString = new ValidString();
                    validString.isValid();
                }
                case 3 -> {
                    GameOfLife gameOfLife = new com.company.implem.GameOfLife();
                    gameOfLife.game();
                }
            }
        } while (true);
    }

    @Override
    public void menuLevel1() {
        System.out.println("Введите номер задания которое хотите выполнить: ");
        System.out.println("1. Возвращение числа уникальных символов");
        System.out.println("2. Ход коня ");
        System.out.println("3. Площадь треугольника");
        System.out.println("0 - выход из программы");

    }
}
