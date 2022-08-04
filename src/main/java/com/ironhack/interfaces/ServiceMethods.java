package com.ironhack.interfaces;

import com.ironhack.model.Contact;

public interface ServiceMethods {

    void show();

    void show(int id);

    void delete(int id);

    <T> void delete(T object);

    <T> T getById(int id);


}
