package com.ironhack.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Serialize implements Serializable {
    // Serial version ID
    protected static long serialVersionUID;
    protected int id;

    static {
        serialVersionUID = 0L; // No modify
    }

    public Serialize(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    /**
     * This method is called during serialization.
     *
     * @param oos
     */
    protected void writeObject(ObjectOutputStream oos) {
    }

    /**
     * This method is called during deserialization.
     *
     * @param ois
     */
    protected void readObject(ObjectInputStream ois) {
    }

}
