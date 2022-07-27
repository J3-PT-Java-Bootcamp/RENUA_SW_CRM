package com.ironhack.serialization;

import java.io.Serializable;

public class Teacher extends Serialize implements Serializable {

        static {
            serialVersionUID = 00003L;
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
