package com.ironhack.model;

import java.util.UUID;

public class Contact extends User {

    static {
        serialVersionUID = 2L; // No modify
    }

    public  Contact(Lead lead) {
        super(lead.name, lead.phoneNumber, lead.email, lead.companyName);
    }
}
