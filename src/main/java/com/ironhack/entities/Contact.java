package com.ironhack.entities;

import java.util.List;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;
    private List<Product> productsOfInterest;

    public Contact(int id, String name, String phoneNumber, String emailAddress, String companyName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Product> getProductsOfInterest() {
        return productsOfInterest;
    }

    public void setProductsOfInterest(List<Product> productsOfInterest) {
        this.productsOfInterest = productsOfInterest;
    }

    @Override
    public String toString() {
        return "Contact{" + "\n" +
                "   id=" + id + "\n" +
                "   name='" + name + '\'' + "\n" +
                "   phoneNumber='" + phoneNumber + '\'' + "\n" +
                "   emailAddress='" + emailAddress + '\'' + "\n" +
                "   companyName='" + companyName + '\'' + "\n" +
                "   productsOfInterest=" + productsOfInterest + "\n" +
                '}';
    }
}
