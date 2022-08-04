package com.ironhack;

import com.ironhack.commander.*;
import com.ironhack.enums.CommandType;
import com.ironhack.service.LeadService;

public class Main {
    public static void main(String[] args) {
        final var commander = new Commander<CommandType>(new Command[] {
            new Command<>("exit", CommandType.EXIT),
            new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                LeadService.createLead();
            }),
            new Command<>("show leads", CommandType.SHOW_LEADS).addOnRun((cr) -> {
                LeadService.show();
            }),
            new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                LeadService.show(cr.getIntegerParameter("id"));
            }),
            new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
            }),
            new Command<>("close-lost :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
            }),
            new Command<>("close-won :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
            }),
        });

        // Run event when a command is executed
        commander.setAutorun(true);

        do {
            var command = commander.askForCommand();
            if(command.getResult() == CommandType.EXIT) break;
        } while (true);
    }
}