package com.ironhack.service;

import java.util.UUID;

public abstract class MethodsService {

    protected static void show() {}

    protected static void show(int id) {}

    protected static void delete(int id) {}

    protected static <T> void delete(T object) {}

    protected static <T> T getById(UUID id) {
        return null;
    }

    protected static void put(Object object) {}
}
