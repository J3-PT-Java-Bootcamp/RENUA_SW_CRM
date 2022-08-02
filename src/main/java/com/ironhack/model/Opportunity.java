package com.ironhack.model;

import com.ironhack.service.OpportunityService;

public class Opportunity {
    private int id;
    private ProductType product;
    private int quantity;
    private Contact decisionMaker;
    private ContactStatus contact;
    private String emailAddress;

    public Opportunity(ProductType product, int quantity, Contact decisionMaker, ContactStatus contact, String emailAddress) {
        this.id = OpportunityService.nextId();
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setContact(contact);
        setEmailAddress(emailAddress);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ContactStatus getContact() {
        return contact;
    }

    public void setContact(ContactStatus contact) {
        this.contact = contact;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
