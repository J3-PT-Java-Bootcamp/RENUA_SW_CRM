package com.ironhack.service;

import com.ironhack.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactService {
    public static List<Contact> contacts = new ArrayList<>();

    private static AtomicInteger nextContactId = new AtomicInteger(0);

    public static Contact createContact(String name, String phoneNumber, String email, String companyName) {
        return new Contact(nextContactId.incrementAndGet(), name, phoneNumber, companyName, email);
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static void showContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
}
