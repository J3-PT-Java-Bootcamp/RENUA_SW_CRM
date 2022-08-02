package com.ironhack.service;

import com.ironhack.model.Lead;
import com.ironhack.model.Opportunity;

import java.util.HashMap;
import java.util.Map;

public class OpportunityService {

    private static Map<Integer, Opportunity> opportunities = new HashMap<>();

    public static Opportunity createFromLead(Lead lead) {
        // return new Opportunity(); // Instantiate opportunity
    }

    public static int nextId() {
        return opportunities.size();
    }
}