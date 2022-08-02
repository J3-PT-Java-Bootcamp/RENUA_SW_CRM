package com.ironhack;

import com.ironhack.commander.*;
import com.ironhack.service.LeadService;

enum CommandTypes {
    NEW_LEAD,
    SHOW_LEADS,
    EXIT
}

public class Main {
    public static void main(String[] args) {
        final var commander = new Commander<CommandTypes>(new Command[] {
            new Command<>("exit", CommandTypes.EXIT),
            new Command<>("new lead", CommandTypes.NEW_LEAD).addOnRun((cr) -> {
                LeadService.createLead();
            }),
            new Command<>("show leads", CommandTypes.SHOW_LEADS).addOnRun((cr) -> {
                LeadService.showLeads();
            }),
        });

        // Run event when a command is executed
        commander.setAutorun(true);

        do {
            var command = commander.askForCommand();
            if(command.getResult() == CommandTypes.EXIT) break;
        } while (true);
    }
}