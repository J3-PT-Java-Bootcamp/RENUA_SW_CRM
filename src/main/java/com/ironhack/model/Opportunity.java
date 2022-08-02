package com.ironhack.model;

import com.ironhack.serialization.Serialize;

import java.util.UUID;

public class Opportunity extends Serialize {

    private ProductType product;
    private int quantity;
    private Contact decisionMaker;
    private OpportunityStatus status;

    static {
        serialVersionUID = 00003L; // No modify
    }

    public Opportunity(ProductType product, int quantity, Contact decisionMaker, OpportunityStatus status) {
        super(UUID.randomUUID());
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public UUID getId() {
        return id;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
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

    public OpportunityStatus getStatus() {
        return status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }
}
