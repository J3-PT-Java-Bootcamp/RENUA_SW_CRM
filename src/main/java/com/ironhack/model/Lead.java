package com.ironhack.model;

import com.ironhack.service.LeadService;

import java.io.Serializable;

public class Lead extends User {

    static {
        serialVersionUID = 3L; // No modify
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(LeadService.nextId(), name, phoneNumber, email, companyName);
    }
}
