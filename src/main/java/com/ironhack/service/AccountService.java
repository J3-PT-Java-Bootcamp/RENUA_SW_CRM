package com.ironhack.service;

import com.ironhack.model.Account;
import com.ironhack.serialization.Serialization;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountService extends MethodsService {
    private static final Map<UUID, Account> accounts = new HashMap<>();

    public static int nextId() {
        return accounts.size();
    }

    public static void show() {
        var objects = Serialization.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Account) {
                var account = (Account) object;
                System.out.println(account.getId() + " -> " + account.getCompanyName());
            }
        });
    }

    public static void show(UUID id) {
        final var account = getById(id);
        System.out.println(account.getId() + " -> " + account.getCompanyName());
    }

    public static void delete(UUID id) {
        Serialization.delete(id);
    }

    public static <T> void delete(T account) {
        Serialization.delete((Account) account);
    }

    public static Account getById(UUID id) {
        return accounts.get(id);
    }
}
