package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LeadService {
    private static final Map<UUID, Lead> leads = new HashMap<>();
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

//        leads.put(lead.getId(), lead);
        Serialization.put(lead);

        return lead;
    }
    public static Lead getLeadById(UUID id) {

        return leads.get(id);
    }
    public static void deleteLead(UUID id) {
//        final Lead lead = getLeadById(id);
//        leads.remove(id);
//        return lead;

        Serialization.delete(id);
    }
    public static void deleteLead(Lead lead) {
        Serialization.delete(lead);
    }
    public static void showLeads() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Lead) {
                var lead = (Lead) object;
                System.out.println(lead.getId() + " -> " + lead.getName());
            }
        });
    }
    public static void showLead(UUID id) {
        final var lead = getLeadById(id);
        System.out.println(lead.getId() + " -> " + lead.getName());
    }
    public static void convertLeadToOpportunity(UUID id) {
        final var lead = getLeadById(id);
        deleteLead(lead);
        OpportunityService.createFromLead(lead);
    }
}