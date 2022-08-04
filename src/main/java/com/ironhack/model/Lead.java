package com.ironhack.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class Lead extends User {

    static {
        serialVersionUID = 1L; // No modif
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
