package com.ironhack.model;

import java.io.Serializable;

public class Lead extends User implements Serializable {

    public Lead(int id, String name, String phoneNumber, String email, String companyName) {
        super(id, name, phoneNumber, email, companyName);
    }

    @Override
    public String toString() {
        return "Lead{" +  "\n" +
                "  id=" + id + "\n" +
                "  name='" + name + '\'' + "\n" +
                "  phoneNumber='" + phoneNumber + '\'' + "\n" +
                "  email='" + email + '\'' + "\n" +
                "  companyName='" + companyName + '\'' + "\n" +
                '}';
    }
}
