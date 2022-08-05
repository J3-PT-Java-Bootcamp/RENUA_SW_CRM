package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LeadService extends MethodsService {
    private static Map<UUID, Lead> leads = new HashMap<>();

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
        put(lead);

        System.out.print("\nLead created: " + lead.getId());

        return lead;
    }

    public static void convertLeadToOpportunity(UUID id) {
        final var lead = getById(id);
        delete(lead);
        var opportunity = OpportunityService.createOpportunity(lead);
        var account = AccountService.createAccount(opportunity);
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

    public static void show(UUID id) {
        final var lead = getById(id);
        System.out.println(lead.getId() + " -> " + lead.getName());
    }

    public static void delete(UUID id) {
        leads.remove(id);
        Serialization.delete(id);
    }

    public static <T> void delete(T lead) {
        leads.remove(((Lead) lead).getId());
        Serialization.delete((Lead) lead);
    }

    public static Lead getById(UUID id) {
        return leads.get(id);
    }

    public static void put(Lead lead) {
        leads.put(lead.getId(), lead);
        Serialization.put(lead);
    }
}