package com.ironhack;

import com.ironhack.commander.Command;
import com.ironhack.commander.Commander;

enum CommandType {
    saySth
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var commander = new Commander<CommandType>(new Command[] {
            new Command<>("say :word", CommandType.saySth).addOnRun((cr) -> {
                System.out.println(cr.getParameter("word"));
            })
        });

        final var result = commander.askForCommand();
        result.run();
    }
}