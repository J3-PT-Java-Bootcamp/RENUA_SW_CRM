package com.ironhack.service;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.*;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OpportunityService extends MethodsService {

    private static final Map<UUID, Opportunity> opportunities = new HashMap<>();
    public static Opportunity createFromLead(Lead lead) {
        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

        Product product = new Product[] {Product.HYBRID, Product.FLATBED, Product.BOX}[UserInput.getIntBetween(1,3)];

        System.out.print("\nNumber of trucks:");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        var contact = new Contact(lead);
        //TODO: implement put method in ContactService Serialization.put(contact)

        var opportunity = new Opportunity(product, trucksNum, contact.getId(), Status.OPEN);
        Serialization.put(opportunity);

        return opportunity;
    }

    public static int nextId() {
        return opportunities.size();
    }

    public void updateCloseLostStatus(UUID id) {
        var opportunity = getById(id);
        opportunity.setStatus(Status.CLOSED_LOST);
        // TODO: Implement save method
    }

    public void updateCloseWonStatus(UUID id) {
        var opportunity = getById(id);
        opportunity.setStatus(Status.CLOSED_WON);
        // TODO: Implement save method
    }

    public static void show() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Opportunity) {
                var opportunity = (Opportunity) object;
                System.out.println(opportunity.getId() + " -> " + opportunity.getStatus());
            }
        });
    }

    public static void show(UUID id) {
        final var opportunity = getById(id);
        System.out.println(opportunity.getId() + " -> " + opportunity.getStatus());
    }

    public static void delete(UUID id) {
        Serialization.delete(id);
    }

    public static <T> void delete(T opportunity) {
        Serialization.delete((Opportunity) opportunity);
    }

    public static Opportunity getById(UUID id) {
        return opportunities.get(id);
    }
}