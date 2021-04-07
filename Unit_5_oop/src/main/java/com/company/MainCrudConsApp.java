package com.company;

import com.company.userController.UserController;

import java.io.IOException;

public class MainCrudConsApp {
    public static void main(String[] args) throws IOException {
        UserController userController = new UserController();
        userController.run();
    }
}
