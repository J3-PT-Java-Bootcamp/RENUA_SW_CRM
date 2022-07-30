package com.ironhack;

public class Lead extends User {
    private int id;
    private String companyName;
    private Product[] productsInterest;

    public Lead(String name, String phoneNumber, int id, String companyName, Product[] productsInterest) {
        super(name, phoneNumber);
        setId(id);
        setCompanyName(companyName);
        setProductsInterest(productsInterest);
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
