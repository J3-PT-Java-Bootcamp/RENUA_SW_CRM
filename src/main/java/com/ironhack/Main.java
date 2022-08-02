package com.ironhack;

import com.ironhack.commander.*;

enum CommandTypes {
    NEW_LEAD,
    EXIT
}

public class Main {
    public static void main(String[] args) {
        final var commander = new Commander<CommandTypes>(new Command[] {
            new Command<>("exit", CommandTypes.EXIT),
            new Command<>("new lead", CommandTypes.NEW_LEAD),
        });

        // Run event when a command is executed
        commander.setAutorun(true);

        do {
            var command = commander.askForCommand();
            if(command.getResult() == CommandTypes.EXIT) break;
        } while (true);
    }
}