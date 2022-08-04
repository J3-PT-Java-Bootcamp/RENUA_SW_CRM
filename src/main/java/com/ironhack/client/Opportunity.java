package com.ironhack.client;

import com.ironhack.enums.ProductType;
import com.ironhack.enums.StatusOption;
import com.ironhack.entities.Contact;

public class Opportunity {
    private int id;
    private ProductType productType;
    private int quantity;
    private Contact decisionMaker;
    private StatusOption statusOption;

    public Opportunity(int id, ProductType productType, int quantity, Contact decisionMaker, StatusOption statusOption) {
        this.id = id;
        this.productType = productType;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.statusOption = statusOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public StatusOption getStatusOption() {
        return statusOption;
    }

    public void setStatusOption(StatusOption statusOption) {
        this.statusOption = statusOption;
    }

    @Override
    public String toString() {
        return "Opportunity{" + "\n" +
                "   id=" + id + "\n" +
                "   productType=" + productType + "\n" +
                "   quantity=" + quantity + "\n" +
                "   decisionMaker=" + decisionMaker + "\n" +
                "   statusOption=" + statusOption + "\n" +
                '}';
    }
}
