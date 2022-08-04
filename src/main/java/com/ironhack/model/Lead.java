package com.ironhack.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

public class Lead extends User implements Serializable {

    static {
        serialVersionUID = 1L; // No modif
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
