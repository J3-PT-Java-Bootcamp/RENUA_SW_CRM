package com.ironhack.client;

import com.ironhack.enums.IndustryType;
import com.ironhack.entities.Contact;

import java.util.ArrayList;
import java.util.List;

//An account represents the company
public class Account {
    private int id;
    private String companyName;
    private IndustryType industryType;
    private int employeeCount;
    private String city;
    private String country;
    public List<Contact> contactList = new ArrayList<>();
    public List<Opportunity> opportunityList = new ArrayList<>();

    public Account(int id, String companyName, IndustryType industryType, int employeeCount, String city, String country) {
        setId(id);
        setCompanyName(companyName);
        setIndustryType(industryType);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public IndustryType getIndustryType() {
        return industryType;
    }

    public void setIndustryType(IndustryType industryType) {
        this.industryType = industryType;
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

    public void addContactToContactList(Contact contact) {
        this.contactList.add(contact);
    }

    public void addOpportunityToOpportunityList(Opportunity opportunity) {
        this.opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return "Account{" + "\n" +
                " id=" + id + "\n" +
                " companyName='" + companyName + '\'' + "\n" +
                " industryType=" + industryType + "\n" +
                " employeeCount=" + employeeCount + "\n" +
                " city='" + city + '\'' + "\n" +
                " country='" + country + '\'' + "\n" +
                " contactList=" + contactList + "\n" +
                " opportunityList=" + opportunityList + "\n" +
                '}';
    }
}
