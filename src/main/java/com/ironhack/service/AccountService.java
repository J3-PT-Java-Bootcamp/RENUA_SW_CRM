package com.ironhack.service;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.Account;
import com.ironhack.model.Opportunity;
import com.ironhack.serialization.Serialization;
import com.ironhack.userinput.UserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountService extends MethodsService {
    private static final Map<UUID, Account> accounts = new HashMap<>();

    public static int nextId() {
        return accounts.size();
    }

    public static Account createAccount(Opportunity opportunity) {

        System.out.print("\nWrite industry number:\n");

        System.out.println("1: PRODUCE");
        System.out.println("2: ECOMMERCE");
        System.out.println("3: MANUFACTURING");
        System.out.println("4: MEDICAL");
        System.out.println("5: OTHER");

        Industry industry = new Industry[] {
            Industry.PRODUCE,
            Industry.ECOMMERCE,
            Industry.MANUFACTURING,
            Industry.MEDICAL,
            Industry.OTHER
        }[UserInput.getIntBetween(1,5)];

        System.out.print("\nNumber of employees (Between 0 and 999999999):\n");
        int employeeCount = UserInput.getIntBetween(0, 999999999);

        System.out.print("\nWrite city:\n");
        String city = UserInput.readText();

        System.out.print("\nWrite country:\n");
        String country = UserInput.readText();

        var contact = ContactService.getById(opportunity.getDecisionMaker());
        var companyName = contact.getCompanyName();

        var opportunityList = new ArrayList<UUID>();
        opportunityList.add(opportunity.getId());

        var contactList = new ArrayList<UUID>();
        contactList.add(opportunity.getDecisionMaker());

        var account = new Account(industry, employeeCount, city, country, companyName, contactList, opportunityList);
        put(account);

        System.out.print("Account created: " + account.getId());

        return account;
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

    public static void put(Account account) {
        accounts.put(account.getId(), account);
        Serialization.put(account);
    }
}
