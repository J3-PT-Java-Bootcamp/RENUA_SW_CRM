package com.ironhack.service;

import com.ironhack.model.*;
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

        ProductType product = new ProductType[] {ProductType.HIBRYD, ProductType.FLATBED, ProductType.BOX}[UserInput.getIntBetween(1,3)];

        System.out.print("\nNumber of trucks:");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        final var contact = new Contact();

        return new Opportunity(product, trucksNum, contact, ContactStatus.OPEN, lead.getEmail());
    }

    public static int nextId() {
        return opportunities.size();
    }
}