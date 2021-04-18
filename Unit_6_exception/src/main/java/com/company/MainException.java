package com.company;

import com.company.controller.ConsoleController;
import com.company.exception.DateFormatException;

public class MainException {
    public static void main(String[] args) throws DateFormatException {
        ConsoleController myController = new ConsoleController();
        myController.run();
    }
}
