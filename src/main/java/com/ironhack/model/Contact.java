package com.ironhack.model;

import java.io.Serializable;
import java.util.Map;

public class Contact extends User implements Serializable {
    private int id;

    public Contact(int id, String name, String phoneNumber, String companyName, String email) {
        super(id, name, phoneNumber, companyName, email);
        //productsOfInterest.put(productName, quantity);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" + "\n" +
                "    id=" + id + "\n" +
                "    name='" + name + '\'' + "\n" +
                "    phoneNumber='" + phoneNumber + '\'' + "\n" +
                "    email='" + email + '\'' + "\n" +
                "    companyName='" + companyName + '\'' + "\n" +
                "  }";
    }
}
