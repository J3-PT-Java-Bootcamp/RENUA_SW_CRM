package com.ironhack;

import com.ironhack.commander.*;
import com.ironhack.enums.CommandType;
import com.ironhack.service.*;

public class Main {
    public static void main(String[] args) {

        LeadService.createTwoLeadExamples();

        final var commander = new Commander<CommandType>(new Command[] {
            new Command<>("exit", CommandType.EXIT),
            new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                LeadService.createLead();
            }),
            new Command<>("show leads", CommandType.SHOW_LEADS).addOnRun((cr) -> {
                LeadService.showLeads();
            }),
            new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                LeadService.showLead(cr.getIntegerParameter("id"));
            }),
            new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                LeadService.convertLeadToOpportunity(cr.getIntegerParameter("id"));
            }),
            new Command<>("close-lost :id", CommandType.CLOSE_LOST).addOnRun((cr) -> {
                OpportunityService.updateCloseLostStatus(cr.getIntegerParameter("id"));
            }),
            new Command<>("close-won :id", CommandType.CLOSE_WON).addOnRun((cr) -> {
                OpportunityService.updateCloseWonStatus(cr.getIntegerParameter("id"));
            }),
            new Command<>("show users", CommandType.SHOW_USERS).addOnRun((cr) -> {
                UserService.showUsers();
            }),
            new Command<>("show contacts", CommandType.SHOW_CONTACTS).addOnRun((cr) -> {
                ContactService.showContacts();
            }),
            new Command<>("show opportunities", CommandType.SHOW_OPPORTUNITIES).addOnRun((cr) -> {
                OpportunityService.showOpportunities();
            }),
            new Command<>("show accounts", CommandType.SHOW_ACCOUNTS).addOnRun((cr) -> {
                AccountService.showAccounts();
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