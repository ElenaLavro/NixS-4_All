package com.company.implem;

import com.company.Calculations;

public class AreaOfTriangle {
    ConsHelper ch = new ConsHelper();

    public void Area() {
        System.out.println("Введите координаты точки А: ");
        System.out.print("x = ");
        int Ax = ch.number();
        System.out.print("y = ");
        int Ay = ch.number();
        System.out.println("Введите координаты точки B: ");
        System.out.print("x = ");
        int Bx = ch.number();
        System.out.print("y = ");
        int By = ch.number();
        System.out.println("Введите координаты точки C: ");
        System.out.print("x = ");
        int Cx = ch.number();
        System.out.print("y = ");
        int Cy = ch.number();

        System.out.println(Calculations.areaOfTR(Ax, Ay, Bx, By, Cx, Cy));
    }
}
