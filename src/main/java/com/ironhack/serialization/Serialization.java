package com.ironhack.serialization;

import java.io.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Serialization<T> {

    // Creating a map of the file names and the file paths.
    private final static EnumMap<Table, String> TABLES;


    // A static block. It is executed when the class is loaded, before the constructor.
    static {
        TABLES = new EnumMap<>(Table.class);
        TABLES.put(Table.USER, "src/main/java/com/ironhack/serialization/serialised-data-user.txt");
        TABLES.put(Table.ACCOUNT, "src/main/java/com/ironhack/serialization/serialised-data-account.txt");
        TABLES.put(Table.LEAD, "src/main/java/com/ironhack/serialization/serialised-data-lead.txt");
        TABLES.put(Table.OPPORTUNITY, "src/main/java/com/ironhack/serialization/serialised-data-opportunity.txt");
        TABLES.put(Table.CONTACT, "src/main/java/com/ironhack/serialization/serialised-data-contact.txt");
    }

    /**
     * It takes a map and a file name, and saves the map to the file using Serialization.
     *
     * @param map The map that you want to save.
     * @param table The name of the file to be saved.
     */
    private static void save(Map map, Table table) {

        try (FileOutputStream fos = new FileOutputStream(TABLES.get(table));
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(map);
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            e.printStackTrace();
        } catch (IOException e) {
            // Error in converting the Object to bytes
            e.printStackTrace();
        }
    }

    /**
     * It reads the file and converts the bytes to an object
     *
     * @param table The name of the file to be read.
     * @return A map of the data that was saved in the file.
     */
    private static Map read(Table table) throws FileNotFoundException {
        Map map = null;

        try (FileInputStream fis = new FileInputStream(TABLES.get(table)); ObjectInputStream ois = new ObjectInputStream(fis);) {
            map = (Map) ois.readObject();
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            // Error in converting the Object to bytes
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // You are converting an invalid stream to Object
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Read the file, get the object with the given id, and return it.
     *
     * @param id The id of the object you want to get.
     * @param table The name of the file to read from.
     * @return The object with the given id.
     */
    public static Object getById(int id, Table table) {
        Map map;

        try {
            map = read(table);
            return map.get(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the file and returns a map of all the key-value pairs
     *
     * @param table The name of the file to read from.
     * @return A map of the contents of the file.
     */
    public static Map getAll(Table table) {
        Map map;

        try {
            map = read(table);
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * If the file exists, read it, add the object to the map, and save the map. If the file doesn't exist, create a new
     * map, add the object to the map, and save the map
     *
     * @param object The object to be saved.
     * @param table The name of the file to be saved.
     */
    public static void put(Serialize object, Table table) {

        Map map;

        try {
            map = read(table);
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.put(object.getId(), object);
        save(map, table);
    }

    /**
     * Replace the object in the file with the same id as the object passed in
     *
     * @param object the object to be replaced
     * @param table The name of the file to be read.
     */
    public static void replace(Serialize object, Table table) {
        Map map;

        try {
            map = read(table);
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.replace(object.getId(), object);
        save(map, table);
    }

    /**
     * Delete the object from the map.
     *
     * @param object The object to be deleted.
     * @param table The name of the file to be saved.
     */
    public static void delete(Serialize object, Table table) {
        Map map;

        try {
            map = read(table);
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(object.getId());
        save(map, table);
    }

    /**
     * Delete the record with the given id from the given table.
     *
     * @param id The id of the object you want to delete.
     * @param table The table to save to.
     */
    public static void delete(int id, Table table) {
        Map map;

        try {
            map = read(table);
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(id);
        save(map, table);
    }
}
