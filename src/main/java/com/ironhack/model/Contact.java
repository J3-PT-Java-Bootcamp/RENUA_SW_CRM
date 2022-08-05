package com.ironhack.model;

import com.ironhack.service.ContactService;

import java.io.Serializable;

public class Contact extends User {

    static {
        serialVersionUID = 4L; // No modify
    }

    public  Contact(Lead lead) {
        super(lead.name, lead.phoneNumber, lead.email, lead.companyName);
    }
}
