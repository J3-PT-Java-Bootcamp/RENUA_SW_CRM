package com.ironhack.service;

import com.ironhack.model.Contact;
import com.ironhack.model.Lead;
import junit.framework.TestCase;

public class ContactServiceTest extends TestCase {

    public void testShow() {
        ContactService.show();
    }

    public void testPut() {
        ContactService.put(new Contact(new Lead("Name", "555555555", "name@renuasw.org", "Renua SW")));
    }
}