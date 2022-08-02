package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;

public class LeadService {
    private static Map<Integer, Lead> leads = new HashMap<>();
    public static int nextId() {
        return leads.size();
    }
    public static Lead createLead() {
        System.out.print("\nLead name: ");
        final String name = UserInput.readText();

        System.out.print("\nLead phone number: ");
        final String leadPn = UserInput.readText();

        System.out.print("\nLead email");
        final String leadEmail = UserInput.readText();

        System.out.print("\nCompany name");
        final String companyName = UserInput.readText();

        final var lead = new Lead(name, leadPn, companyName, leadEmail);
        leads.put(lead.getId(), lead);
        return lead;
    }
    public static Lead getLeadById(int id) {
        return leads.get(id);
    }
    public static Lead deleteLead(int id) {
        final Lead lead = getLeadById(id);
        leads.remove(id);
        return lead;
    }
    public static Lead deleteLead(Lead lead) {
        leads.remove(lead.getId());
        return lead;
    }
    public static void showLeads() {
        leads.forEach((id, lead) -> {
            System.out.println(lead.getId() + " -> " + lead.getName());
        });
    }
    public static void showLead(int id) {
        final var lead = getLeadById(id);
        System.out.println(lead.getId() + " -> " + lead.getName());
    }
    public static void convertLeadToOpportunity(int id) {
        final var lead = getLeadById(id);
        deleteLead(lead);
        OpportunityService.createFromLead(lead);
    }
}