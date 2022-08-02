package com.ironhack.model;

import com.ironhack.serialization.Serialize;

import java.util.List;
import java.util.UUID;

public class Account extends Serialize {

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private String companyName; // This attribute can be removed; it appears in one place in the exercise description and not in another.
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    static {
        serialVersionUID = 00004L; // No modify
    }

    public Account(Industry industry, int employeeCount, String city, String country, String companyName, List<Contact> contactList, List<Opportunity> opportunityList) {
        super(UUID.randomUUID());
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.companyName = companyName;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }
}