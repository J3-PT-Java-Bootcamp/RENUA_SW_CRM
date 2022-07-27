package com.ironhack.serialization;

import java.io.Serializable;

public class Student extends Serialize implements Serializable {

    static {
        serialVersionUID = 00002L;
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
