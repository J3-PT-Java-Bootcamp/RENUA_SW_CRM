package com.ironhack.model;

public class Account {
    private int id;
    private IndustryType industryType;
    private String city;
    private String country;
    private Contact[] contacts;
    private Opportunity[] opportunities;

    public Account(int id, IndustryType industryType, String city, String country, Contact[] contacts, Opportunity[] opportunities) {
        setId(id);
        setIndustryType(industryType);
        setCity(city);
        setCountry(country);
        setContacts(contacts);
        setOpportunities(opportunities);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IndustryType getIndustryType() {
        return industryType;
    }

    public void setIndustryType(IndustryType industryType) {
        this.industryType = industryType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public Opportunity[] getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Opportunity[] opportunities) {
        this.opportunities = opportunities;
    }
}
