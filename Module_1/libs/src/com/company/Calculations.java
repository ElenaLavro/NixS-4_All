package com.company;

public interface Calculations {
    static boolean isRightPosition(char letter, int num) {
        return (letter >= 'a' && letter <= 'h') && (num >= 1 && num <= 8);
    }

    static boolean isPossible(char x, int y, char x1, int y1) {
        return (isRightPosition(x, y) || isRightPosition(x1, y1)) &&
                Math.abs(x - x1) + Math.abs(y - y1) == 3;
    }

    static double areaOfTR(int x1, int y1, int x2, int y2, int x3, int y3) {
        System.out.print("Площадь = ");
        return (double) Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) / 2;
    }
}
