package com.ironhack;

import com.ironhack.commander.*;
import com.ironhack.enums.CommandType;
import com.ironhack.service.AccountService;
import com.ironhack.service.ContactService;
import com.ironhack.service.LeadService;
import com.ironhack.service.OpportunityService;

public class Main {
    public static void main(String[] args) {
        final var commander = new Commander<CommandType>(new Command[] {

            // TODO: Say hello to the user and inform him about the help command

            new Command<>("exit", CommandType.EXIT),
            new Command<>("help", CommandType.HELP).addOnRun((cr) -> {
                // TODO: List in console all commands
            }),

            new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                LeadService.createLead();
            }),

            // Show commands
            new Command<>("show leads", CommandType.SHOW_LEADS).addOnRun((cr) -> {
                LeadService.show();
            }),
            new Command<>("show opportunities", CommandType.SHOW_OPPORTUNITIES).addOnRun((cr) -> {
                OpportunityService.show();
            }),
            new Command<>("show accounts", CommandType.SHOW_ACCOUNTS).addOnRun((cr) -> {
                AccountService.show();
            }),
            new Command<>("show contacts", CommandType.SHOW_CONTACTS).addOnRun((cr) -> {
                ContactService.show();
            }),

            // Lookup commands
            new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                LeadService.show(cr.getIntegerParameter("id"));
            }),
            new Command<>("lookup contact :id", CommandType.LOOKUP_CONTACT_ID).addOnRun((cr) -> {
                ContactService.show(cr.getIntegerParameter("id"));
            }),
            new Command<>("lookup opportunity :id", CommandType.LOOKUP_OPPORTUNITY_ID).addOnRun((cr) -> {
                OpportunityService.show(cr.getIntegerParameter("id"));
            }),
            new Command<>("lookup account :id", CommandType.LOOKUP_ACCOUNT_ID).addOnRun((cr) -> {
                AccountService.show(cr.getIntegerParameter("id"));
            }),
                

            new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
            }),
            new Command<>("close-lost :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                // TODO: Close lead as lost
            }),
            new Command<>("close-won :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                // TODO: Close lead as won
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