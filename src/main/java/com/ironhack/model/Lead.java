package com.ironhack.model;

import java.io.Serializable;

public class Lead extends User implements Serializable {

    static {
        serialVersionUID = 1L; // No modif
    }

    public Lead(int id, String name, String phoneNumber, String email, String companyName) {
        super(id, name, phoneNumber, email, companyName);
    }
}
