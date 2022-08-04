package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;

public class LeadService extends MethodsService {
    private static Map<Integer, Lead> leads = new HashMap<>();

    static {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Lead) {
                var lead = (Lead) object;
                leads.put(lead.getId(), lead);
            }
        });
    }
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
        leads.put(lead.getId(), lead);

        return lead;
    }

    public static void convertLeadToOpportunity(int id) {
        final var lead = getById(id);
        delete(lead);
        OpportunityService.createFromLead(lead);
    }

    public static void show() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Lead) {
                var lead = (Lead) object;
                System.out.println(lead.getId() + " -> " + lead.getName());
            }
        });
    }

    public static void show(int id) {
        final var lead = getById(id);
        System.out.println(lead.getId() + " -> " + lead.getName());
    }

    public static void delete(int id) {
        Serialization.delete(id);
    }

    public static <T> void delete(T lead) {
        Serialization.delete((Lead) lead);
    }

    public static Lead getById(int id) {
        return leads.get(id);
    }
}