package com.ironhack.commander;

import com.ironhack.userinput.UserInput;

public class Commander<T> {
    private final Command<T>[] commands;

    public Commander(Command<T>[] commands) {
        this.commands = commands;
    }

    public CommandResult<T> askForCommand() {
        CommandResult<T> commandResult = null;

        do {
            for (var command : commands) {
                commandResult = command.tryProcessCommand(UserInput.readText());
                if(commandResult != null) break;
            }
            if(commandResult == null) {
                System.out.println("[!] The command does not exist");
            }
        } while (commandResult == null);

        return commandResult;
    }
}
