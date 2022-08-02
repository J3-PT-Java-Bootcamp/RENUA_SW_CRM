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
}