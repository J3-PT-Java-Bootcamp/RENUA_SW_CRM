package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Lead;
import com.ironhack.model.Opportunity;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ironhack.enums.Industry.*;
import static com.ironhack.enums.Product.*;
import static com.ironhack.enums.Status.*;

public class LeadService {
    private static AtomicInteger nextLeadId = new AtomicInteger(0);
    private static final List<Lead> leads = new ArrayList<>();

    public static void createTwoLeadExamples() {
        leads.add(new Lead(134, "Mike", "458745664", "Emerson Produce Company", "mike@emersonproduce.com"));
        leads.add(new Lead(135, "John", "78879875", "Empresa 2","john@empresa2.com"));

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

        final var lead = new Lead(nextLeadId.incrementAndGet(), name, leadPn, companyName, leadEmail);

        leads.add(lead);
        //leads.put(lead.getId(), lead);
        //Serialization.put(lead);

        return lead;// ¿POR QUE SE RETORNA EL LEAD?
    }
    public static Lead getLeadById(int id) {
        for (Lead lead : leads) {
            if (lead.getId() == id) {
                return lead;
            }
        }
        return null;
    }
    public static void deleteLead(int id) {
        Lead lead = getLeadById(id);
        leads.remove(lead);
        //Serialization.delete(id);
    }
    /*public static void deleteLead(Lead lead) {
        Serialization.delete(lead);
    }*/
    public static void showLeads() {
        for (Lead lead : leads) {
            System.out.println(lead.toString());
        }
        //var objects = Serialization.getAll();
        /*objects.forEach((id, object) -> {
            if(object instanceof Lead) {
                var lead = (Lead) object;
                System.out.println(lead.getId() + " -> " + lead.getName());
            }
        });*/
    }
    public static void showLead(int id) {
        final var lead = getLeadById(id);
        System.out.println(lead);
    }

    public static void convertLeadToOpportunity(int id) {
        final var lead = getLeadById(id);

        //Add contact
        Contact contact = ContactService.createContact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()/*, productName, quantity*/);
        ContactService.addContact(contact);
        System.out.println("Contact correctly added to the contact list!\n");

        //Add opportunity
        System.out.println("Please, introduce the Lead Oportunity parameters:");
        System.out.println("product of interest (choose one):");
        for (Product product : Product.values()) {
            System.out.println("    " + product.toString());
        }
        String product = UserInput.readText().toLowerCase();
        System.out.println("Quantity:");
        int quantity = UserInput.readInt();
        Product currentProductType = null;
        switch (product) {
            case "hybrid" -> currentProductType = HYBRID;
            case "flatbet" -> currentProductType = FLATBED;
            case "box" -> currentProductType = BOX;
            default -> System.out.println("Incorrect product type");
        }
        Opportunity opportunity = OpportunityService.createOpportunity(currentProductType, quantity, contact, OPEN);
        OpportunityService.addOpportunity(opportunity);
        System.out.println("Opportunity correctly added to the opportunity list!\n");

        //Add account
        System.out.println("Please, introduce the Lead Account parameters:");
        System.out.println("Industry (choose one):");
        for (Industry industry : Industry.values()) {
            System.out.println("    " + industry.toString());
        }
        String industry = UserInput.readText();
        Industry currentIndustry = null;
        switch (industry) {
            case "produce" -> currentIndustry = PRODUCE;
            case "ecommerce" -> currentIndustry = ECOMMERCE;
            case "manufacturing" -> currentIndustry = MANUFACTURING;
            case "medical" -> currentIndustry = MEDICAL;
            case "other" -> currentIndustry = OTHER;
        }
        System.out.println("Number of Employees:");
        int employeeCount = UserInput.readInt();
        System.out.println("City:");
        String city = UserInput.readText();
        System.out.println("Country:");
        String country = UserInput.readText();
        Account account = AccountService.createAccount(currentIndustry, employeeCount, city, country, ContactService.contacts, OpportunityService.opportunities);
        AccountService.addAccount(account);

        deleteLead(lead.getId());
        //OpportunityService.createFromLead(lead);
    }
}