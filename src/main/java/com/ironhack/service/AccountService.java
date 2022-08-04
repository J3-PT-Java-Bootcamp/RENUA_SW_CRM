package com.ironhack.service;

import com.ironhack.model.Account;
import com.ironhack.model.Contact;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static final Map<Integer, Account> accounts = new HashMap<>();

    public static int nextId() {
        return accounts.size();
    }
}
