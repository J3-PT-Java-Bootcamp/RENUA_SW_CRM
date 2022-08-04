package com.ironhack.entities;

public class User {
    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public User(int id, String name, String phoneNumber, String emailAddress) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User{" + "\n" +
                "id=" + id + "\n" +
                " name='" + name + '\'' + "\n" +
                " phoneNumber='" + phoneNumber + '\'' + "\n" +
                " emailAddress='" + emailAddress + '\'' + "\n" +
                '}';
    }
}