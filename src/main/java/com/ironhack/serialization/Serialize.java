package com.ironhack.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Serialize {
    // Serial version ID
    protected static long serialVersionUID;
    protected int id;

    static {
        serialVersionUID = 00000L;
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
