package com.ironhack;

public class SalesAssociate extends User {
    private int salesAssociated;

    public SalesAssociate(String name, String phoneNumber, int salesAssociated) {
        super(name, phoneNumber);
        setSalesAssociated(salesAssociated);
    }

    public int getSalesAssociated() {
        return salesAssociated;
    }

    public void setSalesAssociated(int salesAssociated) {
        this.salesAssociated = salesAssociated;
    }
}
