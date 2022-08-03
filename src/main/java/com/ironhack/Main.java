package com.ironhack;

import com.ironhack.commander.*;
import com.ironhack.service.LeadService;

enum CommandTypes {
    NEW_LEAD,
    SHOW_LEADS,
    LOOKUP_LEAD_ID,
    CONVERT_LEAD,
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
            new Command<>("lookup lead :id", CommandTypes.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                LeadService.showLead(cr.getIntegerParameter("id"));
            }),
            new Command<>("convert :id", CommandTypes.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
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