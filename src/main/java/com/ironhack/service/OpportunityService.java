package com.ironhack.service;

import com.ironhack.model.*;

import java.util.HashMap;
import java.util.Map;

public class OpportunityService {

    private static final Map<Integer, Opportunity> opportunities = new HashMap<>();

    public static Opportunity createFromLead(Lead lead) {
        System.out.print("\nWrite product:");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

//        ProductType product = new ProductType[] {ProductType.HYBRID, ProductType.FLATBED, ProductType.BOX}[UserInput.getIntBetween(1,3)];
        Product product = new Product[] {Product.HYBRID, Product.FLATBED, Product.BOX}[2];

        System.out.print("\nNumber of trucks:");
//        int trucksNum = UserInput.getIntBetween(0, 9999);
        int trucksNum = 1000;

        var contact = new Contact(lead);
        // TODO: Save contact

        return new Opportunity(product, trucksNum, contact.getId(), Status.OPEN);
        // TODO: Save opportunity
    }

    public static int nextId() {
        return opportunities.size();
    }
}