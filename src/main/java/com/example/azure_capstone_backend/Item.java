// src/main/java/com/example/azurecapstonebackend/Item.java
package com.example.azurecapstonebackend;

/**
 * Represents a simple data model for an item.
 * This class will be automatically converted to/from JSON by Spring Boot.
 */
public class Item {
    private int id;
    private String name;
    private String description;

    // Constructor to initialize an Item object
    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Default constructor needed for JSON deserialization by some frameworks (good practice)
    public Item() {
    }

    // Getters and Setters for all fields. These are essential for JSON serialization/deserialization.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
