package com.ironhack.model;

import com.ironhack.service.LeadService;

public class Lead extends User {
    private int id;
    private String companyName;
    private Product[] productsInterest;

    public Lead(String name, String phoneNumber, String companyName, String email) {
        super(name, phoneNumber, email);
        setId(LeadService.nextId());
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

    public Product[] getProductsInterest() {
        return productsInterest;
    }

    public void setProductsInterest(Product[] productsInterest) {
        this.productsInterest = productsInterest;
    }
}
