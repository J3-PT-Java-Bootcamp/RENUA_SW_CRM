package com.ironhack.client;

import com.ironhack.entities.Product;
import com.ironhack.entities.User;

import java.util.HashMap;

public class Lead extends User {
    private int id;
    private String companyName;
    private final HashMap<Product, Integer> productsOfInterest = new HashMap<>();

    public Lead(int id, String name, String phoneNumber, String emailAddress, String companyName) {
        super(id, name, phoneNumber, emailAddress);
        setId(id);
        setCompanyName(companyName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public HashMap<Product, Integer> getProductsOfInterest() {
        return productsOfInterest;
    }

    public void addProductsOfInterest(Product product, int numProducts) {
        this.productsOfInterest.put(product, numProducts);
    }

    @Override
    public String toString() {
        return "Lead{" + "\n" +
                " id=" + id + "\n" +
                " name='" + this.getName() + '\'' + "\n" +
                " phoneNumber='" + this.getPhoneNumber() + '\'' + "\n" +
                " emailAddress='" + this.getEmailAddress() + '\'' + "\n" +
                " companyName='" + companyName + '\'' + "\n" +
                " productsOfInterest=" + productsOfInterest + "\n" +
                '}';
    }
}
