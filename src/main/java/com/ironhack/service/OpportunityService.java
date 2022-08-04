package com.ironhack.service;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.*;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;

public class OpportunityService {

    private static final Map<Integer, Opportunity> opportunities = new HashMap<>();
    public static Opportunity createFromLead(Lead lead) {
        System.out.print("\nWrite product:");

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
}