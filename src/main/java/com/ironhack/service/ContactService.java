package com.ironhack.service;

import com.ironhack.model.Contact;
import com.ironhack.serialization.Serialization;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService extends MethodsService {
    private static final Map<UUID, Contact> contacts = new HashMap<>();
    
    public static int nextId() {
        return contacts.size();
    }

    public static void show() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Contact) {
                var contact = (Contact) object;
                System.out.println(contact.getId() + " -> " + contact.getName());
            }
        });
    }

    public static void show(UUID id) {
        final var contact = getById(id);
        System.out.println(contact.getId() + " -> " + contact.getName());
    }

    public static void delete(UUID id) {
        Serialization.delete(id);
    }

    public static <T> void delete(T contact) {
        Serialization.delete((Contact) contact);
    }

    public static Contact getById(UUID id) {
        return contacts.get(id);
    }

    public static void put(Contact contact) {
        contacts.put(contact.getId(), contact);
        Serialization.put(contact);
    }
}
