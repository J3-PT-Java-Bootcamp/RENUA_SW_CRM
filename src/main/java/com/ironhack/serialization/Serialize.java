package com.ironhack.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public abstract class Serialize {
    // Serial version ID
    protected static long serialVersionUID;
    protected UUID id;

    static {
        serialVersionUID = 00000L;
    }

    public Serialize(UUID id) {
        this.id = id;
    }

    public UUID getId() {
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
