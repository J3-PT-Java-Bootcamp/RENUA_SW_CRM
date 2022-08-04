package com.ironhack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LBL lbl = new LBL();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nIntroduce command:");
            String command = scanner.nextLine().toLowerCase();
            String[] arrayCommand = command.split(" ");
            String commandUnited = "";
            if (arrayCommand.length >= 2) {
                commandUnited = arrayCommand[0] + " " + arrayCommand[1];
            } else {
                commandUnited = arrayCommand[0];
            }
            int id = 0;
            if (arrayCommand.length == 3) {
                id = Integer.parseInt(arrayCommand[2]);
            }
            if (arrayCommand.length == 2 && isNumeric(arrayCommand[1])) {
                id = Integer.parseInt(arrayCommand[1]);
                commandUnited = arrayCommand[0];
            }
            switch (commandUnited) {
                case "new lead" -> lbl.createLead();
                case "show leads" -> lbl.showLeads();
                case "lookup lead" -> lbl.showLead(id);
                case "convert" -> lbl.convertLeadToOpportunity(id);
                case "show opportunities" -> lbl.showOpportunities();
                case "show accounts" -> lbl.showAccounts();
                case "close-lost" -> lbl.updateCloseLostStatus(id);
                case "close-won" -> lbl.updateCloseWonStatus(id);
                default -> System.out.println("Unknown command");
            }
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}