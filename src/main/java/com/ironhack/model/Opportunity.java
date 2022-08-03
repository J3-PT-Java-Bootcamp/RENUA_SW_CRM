package com.ironhack.model;

import com.ironhack.serialization.Serialize;

import java.util.UUID;

public class Opportunity extends Serialize {

    private Product product;
    private int quantity;
    private UUID decisionMaker;
    private Status status;

    static {
        serialVersionUID = 00003L; // No modify
    }

    public Opportunity(Product product, int quantity, UUID decisionMaker, Status status) {
        super(UUID.randomUUID());
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(UUID decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
