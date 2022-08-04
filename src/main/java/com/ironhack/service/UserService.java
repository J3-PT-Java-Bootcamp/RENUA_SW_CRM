package com.ironhack.service;

import com.ironhack.model.Contact;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final Map<Integer, Contact> users = new HashMap<>();

    public static int nextId() {
        return users.size();
    }
}
