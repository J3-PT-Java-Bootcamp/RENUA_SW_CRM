package com.ironhack.serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Serialization<T> {

    // Creating a map of the file names and the file paths.
    private final static String DATABASE = "src/main/java/com/ironhack/serialization/serialised-data.txt";


    /**
     * It takes a map and a file name, and saves the map to the file using Serialization.
     *
     * @param map The map that you want to save.
     */
    private static void save(Map map) {

        try {
            FileOutputStream fos = new FileOutputStream(DATABASE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
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
     * @return A map of the data that was saved in the file.
     */
    private static Map read() throws FileNotFoundException {
        Map map = null;

        try {
            FileInputStream fis = new FileInputStream(DATABASE);
            ObjectInputStream ois = new ObjectInputStream(fis);
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
     * @return The object with the given id.
     */
    public static Object getById(int id) {
        Map map;

        try {
            map = read();
            return map.get(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the file and returns a map of all the key-value pairs
     *
     * @return A map of the contents of the file.
     */
    public static Map getAll() {
        Map map;

        try {
            map = read();
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
     */
    public static void put(Serialize object) {

        Map map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        if(map == null) {
            map = new HashMap();
        }

        map.put(object.getId(), object);
        save(map);
    }

    /**
     * Replace the object in the file with the same id as the object passed in
     *
     * @param object the object to be replaced
     */
    public static void replace(Serialize object) {
        Map map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.replace(object.getId(), object);
        save(map);
    }

    /**
     * Delete the object from the map.
     *
     * @param object The object to be deleted.
     */
    public static void delete(Serialize object) {
        Map map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(object.getId());
        save(map);
    }

    /**
     * Delete the record with the given id from the given table.
     *
     * @param id The id of the object you want to delete.
     */
    public static void delete(int id) {
        Map map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(id);
        save(map);
    }
}
