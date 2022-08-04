package com.ironhack.service;

import com.ironhack.interfaces.ServiceMethods;
import com.ironhack.model.Contact;
import com.ironhack.serialization.Serialization;
import com.ironhack.serialization.Serialize;

import java.util.HashMap;
import java.util.Map;

public class ContactService implements ServiceMethods {
    private static final Map<Integer, Contact> contacts = new HashMap<>();
    
    public static int nextId() {
        return contacts.size();
    }

    @Override
    public void show() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Contact) {
                var contact = (Contact) object;
                System.out.println(contact.getId() + " -> " + contact.getName());
            }
        });
    }

    @Override
    public void show(int id) {
        final var contact = getById(id);
        System.out.println(contact.getId() + " -> " + contact.getName());
    }

    @Override
    public void delete(int id) {
        Serialization.delete(id);
    }

    @Override
    public <T> void delete(T contact) {
        Serialization.delete((Contact) contact);
    }

    @Override
    public Contact getById(int id) {
        return contacts.get(id);
    }
}
