package com.ironhack.model;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.serialization.Serialize;
import com.ironhack.service.OpportunityService;

import java.io.Serializable;

public class Opportunity extends Serialize implements Serializable {
    private int id;
    private Product productOfInterest;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(int id, Product product, int quantity, Contact decisionMaker, Status status) {
        super(OpportunityService.nextId());
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return productOfInterest;
    }

    public void setProduct(Product product) {
        this.productOfInterest = product;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" + "\n" +
                "  id=" + id + "\n" +
                "  productOfInterest=" + productOfInterest + "\n" +
                "  quantity=" + quantity + "\n" +
                "  decisionMaker=" + decisionMaker + "\n" +
                "  status=" + status + "\n" +
                "  }";
    }
}
