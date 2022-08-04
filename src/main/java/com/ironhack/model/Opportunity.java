package com.ironhack.model;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.serialization.Serialize;
import com.ironhack.service.OpportunityService;

import java.io.Serializable;

public class Opportunity extends Serialize implements Serializable {

    private Product product;
    private int quantity;
    private int decisionMaker;
    private Status status;

    static {
        serialVersionUID = 3L; // No modify
    }

    public Opportunity(Product product, int quantity, int decisionMaker, Status status) {
        super(OpportunityService.nextId());
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public int getId() {
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

    public int getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(int decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
