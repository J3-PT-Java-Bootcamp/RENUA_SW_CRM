package com.ironhack.model;

import com.ironhack.enums.Industry;
import com.ironhack.serialization.Serialize;
import com.ironhack.service.AccountService;

import java.io.Serializable;
import java.util.List;

public class Account extends Serialize {

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private String companyName; // This attribute can be removed; it appears in one place in the exercise description and not in another.
    private List<Integer> contactList;
    private List<Integer> opportunityList;

    static {
        serialVersionUID = 5L; // No modify
    }

    public Account(Industry industry, int employeeCount, String city, String country, String companyName, List<Integer> contactList, List<Integer> opportunityList) {
        super(AccountService.nextId());
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

    public List<Integer> getContactList() {
        return contactList;
    }

    public void setContactList(List<Integer> contactList) {
        this.contactList = contactList;
    }

    public List<Integer> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Integer> opportunityList) {
        this.opportunityList = opportunityList;
    }
}
