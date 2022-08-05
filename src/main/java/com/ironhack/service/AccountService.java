package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.model.Account;
import com.ironhack.model.Contact;
import com.ironhack.model.Opportunity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountService {
    private static AtomicInteger nextAccountId = new AtomicInteger(0);
    public static final List<Account> accounts = new ArrayList<>();

    public static int nextId() {
        return accounts.size();
    }

    public static void showAccounts() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    public static Account createAccount(Industry currentIndustry, int employeeCount, String city, String country, List<Contact> contactList, List<Opportunity> opportunityList) {
        return new Account(nextAccountId.incrementAndGet(), currentIndustry, employeeCount, city, country, contactList, opportunityList);
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }
}
