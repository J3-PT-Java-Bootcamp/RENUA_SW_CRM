package com.ironhack;

import com.ironhack.client.Account;
import com.ironhack.client.Lead;
import com.ironhack.client.Opportunity;
import com.ironhack.entities.Contact;
import com.ironhack.entities.Product;
import com.ironhack.entities.User;
import com.ironhack.enums.IndustryType;
import com.ironhack.enums.ProductType;
import com.ironhack.enums.StatusOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ironhack.enums.IndustryType.*;
import static com.ironhack.enums.ProductType.*;
import static com.ironhack.enums.StatusOption.*;

public class LBL {
    private static int nextLeadId = 1;
    private static int nextContactId = 1;
    private static int nextOpportunityId = 1;
    private static int nextAccountId = 1;

    List<User> salesAssociates = new ArrayList<>();
    List<Lead> leads = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Contact> contacts = new ArrayList<>();
    List<Opportunity> opportunities = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();

    public LBL() {
        products.add(new Product("Hybrid Truck", 110000f, HYBRID));
        products.add(new Product("Flatbed Truck", 190000f, FLATBED));
        products.add(new Product("Box Truck", 150000f, BOX));

        salesAssociates.add(new User(1, "Sara", "658782546", "sara@lbltruckcompany.com"));

        List<Product> mikeProducts = new ArrayList<>();
        mikeProducts.add(products.get(0));
        mikeProducts.add(products.get(1));
        mikeProducts.add(products.get(2));
        leads.add(new Lead(134, "Mike", "458745664", "mike@emersonproduce.com", "Emerson Produce Company"));
        leads.add(new Lead(135, "John", "78879875", "john@empresa2.com", "Empresa 2"));

    }

    void createLead() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce name: ");
        String name = scanner.nextLine();
        System.out.println("Introduce phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Introduce email address: ");
        String emailAddress = scanner.nextLine();
        System.out.println("Introduce company name: ");
        String companyName = scanner.nextLine();
        leads.add(new Lead(nextLeadId++, name, phoneNumber, emailAddress, companyName));
        System.out.println("Lead correctly added!");

    }

    void showLeads() {
        for (Lead l : leads) {
            System.out.println(l);
        }
    }

    void showLead(int leadId) {
        for (int i = 0; i < leads.size(); i++) {
            if (leads.get(i).getId() == leadId) {
                System.out.println(leads.get(i).toString());
                break;
            }
        }
    }

    void convertLeadToOpportunity(int leadId) {
        Scanner scanner = new Scanner(System.in);
        for (Lead l : leads) {
            if (l.getId() == leadId) {

                //ADD CONTACT
                Contact contact = new Contact(nextContactId++, l.getName(), l.getPhoneNumber(), l.getEmailAddress(), l.getCompanyName());
                contacts.add(contact);
                System.out.println("Contact correctly added to the contact list!\n");

                //ADD PRODUCT_OF_INTEREST AND OPPORTUNITY
                System.out.println("Now introduce a product of interest for the opportunity:");
                System.out.println("Introduce the product name that Mike is interested in:");
                String productName = scanner.nextLine().toLowerCase();
                ProductType currentProductType = null;
                switch (productName) {
                    case "hybrid truck" -> currentProductType = HYBRID;
                    case "flatbet truck" -> currentProductType = FLATBED;
                    case "box truck" -> currentProductType = BOX;
                    default -> System.out.println("Incorrect product type");
                }
                System.out.println("Introduce product quantity that Mike's interested in buying:");
                int quantity = scanner.nextInt();
                //add product_of_interest
                l.addProductsOfInterest(new Product(productName, currentProductType), quantity);
                Opportunity opportunity = new Opportunity(nextOpportunityId++, currentProductType, quantity, contact, StatusOption.OPEN);
                //add opportunity
                opportunities.add(opportunity);
                System.out.println("Opportunity correctly added to the opportunity list!\n");

                //ADD ACCOUNT
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Now introduce the account parameters:");
                System.out.println("Introduce the industry type:");
                String industryType = scanner2.nextLine().toLowerCase();
                IndustryType currentIndustryType = null;
                switch (industryType) {
                    case "produce" -> currentIndustryType = PRODUCE;
                    case "ecommerce" -> currentIndustryType = ECOMMERCE;
                    case "manufacturing" -> currentIndustryType = MANUFACTURING;
                    case "medical" -> currentIndustryType = MEDICAL;
                    case "other" -> currentIndustryType = OTHER;
                }
                System.out.println("Introduce the number of employees:");
                int employeeCount = scanner2.nextInt();
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Introduce the city:");
                String city = scanner3.nextLine();
                System.out.println("Introduce the country:");
                String country = scanner3.nextLine();
                Account account = new Account(nextAccountId++, l.getCompanyName(), currentIndustryType, employeeCount, city, country);
                account.addContactToContactList(contact);
                account.addOpportunityToOpportunityList(opportunity);
                accounts.add(account);
                System.out.println("Account correctly added to the account list!");
                break;
            }
        }
        deleteLead(leadId);
    }

    void updateCloseLostStatus(int opportunityId) {
        for (Opportunity o : opportunities) {
            if (o.getId() == opportunityId) {
                o.setStatusOption(CLOSED_LOST);
                break;
            }
        }
    }

    void updateCloseWonStatus(int opportunityId) {
        for (Opportunity o : opportunities) {
            if (o.getId() == opportunityId) {
                o.setStatusOption(CLOSED_WON);
                break;
            }
        }
    }

    void deleteLead(int leadId) {
        for (Lead l : leads) {
            if (l.getId() == leadId) {
                leads.remove(l);
                break;
            }
        }
    }

    void showOpportunities() {
        for (Opportunity o : opportunities) {
            System.out.println(o.toString());
        }
    }

    void showAccounts() {
        for (Account a : accounts) {
            System.out.println(a.toString());
        }
    }
}
