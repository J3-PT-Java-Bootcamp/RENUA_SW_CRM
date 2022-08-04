package com.ironhack.model;

import com.ironhack.serialization.Serialize;

import java.io.Serializable;

public abstract class User extends Serialize implements Serializable {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;

    public User(int id, String name, String phoneNumber, String email, String companyName) {
        super(id);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
