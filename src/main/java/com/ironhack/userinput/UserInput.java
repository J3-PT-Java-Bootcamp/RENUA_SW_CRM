package com.ironhack.userinput;

import java.util.Scanner;

public class UserInput {
    public static String readText() {
        return new Scanner(System.in).nextLine();
    }
}