package com.ironhack;

import com.ironhack.commander.Command;
import com.ironhack.commander.Commander;

enum CommandType {
    saySth
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var commander = new Commander<CommandType>(new Command<>[] {
            new Command<>("say :word", CommandType.saySth)
        });

        final var result = commander.askForCommand();
        System.out.println(result.getParameters().get("word"));
    }
}