package com.ironhack.model;

import com.ironhack.service.OpportunityService;

public class Opportunity {
    private int id;
    private ProductType productType;
    private int quantity;
    private Contact decisionMaker;
    private ContactStatus contactStatus;
    private String emailAddress;

    public Opportunity(ProductType productType, int quantity, Contact decisionMaker, ContactStatus contactStatus, String emailAddress) {
        this.id = OpportunityService.nextId();
        setProductType(productType);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setContactStatus(contactStatus);
        setEmailAddress(emailAddress);
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

    public ContactStatus getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(ContactStatus contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
