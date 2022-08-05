package com.ironhack.service;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ironhack.enums.Status.CLOSED_LOST;
import static com.ironhack.enums.Status.CLOSED_WON;


public class OpportunityService {

    private static AtomicInteger nextOpportunityId = new AtomicInteger(0);
    public static final List<Opportunity> opportunities = new ArrayList<>();

    public static void addOpportunity(Opportunity opportunity) {
        opportunities.add(opportunity);
    }

    public static Opportunity createOpportunity(Product productType, int quantity, Contact decisionMaker, Status status) {
        return new Opportunity(nextOpportunityId.incrementAndGet(), productType, quantity, decisionMaker, status);
    }

    /*public static Opportunity createFromLead(Lead lead) {
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
    }*/

    public static int nextId() {
        return opportunities.size();
    }

    public static void updateCloseLostStatus(int opportunityId) {
        for (Opportunity opportunity : opportunities) {
            if (opportunity.getId() == opportunityId) {
                opportunity.setStatus(CLOSED_LOST);
                break;
            }
        }
    }

    public static void updateCloseWonStatus(int opportunityId) {
        for (Opportunity opportunity : opportunities) {
            if (opportunity.getId() == opportunityId) {
                opportunity.setStatus(CLOSED_WON);
                break;
            }
        }
    }

    public static void showOpportunities() {
        for (Opportunity opportunity : opportunities) {
            System.out.println(opportunity.toString());
        }
    }
}