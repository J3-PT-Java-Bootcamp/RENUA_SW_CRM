package com.ironhack.service;

public abstract class MethodsService {

    protected static void show() {}

    protected static void show(int id) {}

    protected static void delete(int id) {}

    protected static <T> void delete(T object) {}

    protected static <T> T getById(int id) {
        return null;
    }
}
