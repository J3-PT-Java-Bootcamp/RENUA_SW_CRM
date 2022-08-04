package com.ironhack.model;

import com.ironhack.service.LeadService;

import java.io.Serializable;

public class Lead extends User implements Serializable {

    static {
        serialVersionUID = 1L; // No modif
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(LeadService.nextId(), name, phoneNumber, email, companyName);
    }

    }
}
