// src/main/java/com/example/azurecapstonebackend/ItemController.java
package com.example.azurecapstonebackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST Controller for handling API requests related to items.
 * Uses @RestController to combine @Controller and @ResponseBody.
 * Uses @RequestMapping to define the base path for all methods in this controller.
 */
@RestController
@RequestMapping("/api") // All endpoints in this controller will start with /api
public class ItemController {

    // Simple in-memory list to simulate a data store (no actual database used)
    private static List<Item> items = new ArrayList<>();

    // Static initializer block: this code runs once when the class is loaded,
    // populating our mock data.
    static {
        items.add(new Item(1, "Laptop Pro", "High-performance laptop for professionals."));
        items.add(new Item(2, "Wireless Mouse", "Ergonomic design with long battery life."));
        items.add(new Item(3, "Mechanical Keyboard", "Tactile switches for a satisfying typing experience."));
        items.add(new Item(4, "USB-C Hub", "Expand your connectivity with multiple ports."));
        items.add(new Item(5, "External SSD", "Fast and portable storage solution."));
        items.add(new Item(6, "Gaming Headset", "Immersive audio with a clear microphone."));
    }

    /**
     * GET endpoint to retrieve a list of all items.
     * This endpoint will be accessible at /api/items (e.g., http://localhost:8080/api/items locally).
     * @return A List of Item objects, which Spring Boot will automatically serialize to JSON.
     */
    @GetMapping("/items")
    public List<Item> getAllItems() {
        System.out.println("Backend: Received request for /api/items"); // Log the incoming request
        return items;
    }

    // Future expansion: You could add more API endpoints here, e.g.:
    // @GetMapping("/items/{id}")
    // public Item getItemById(@PathVariable int id) { ... }

    // @PostMapping("/items")
    // public Item addItem(@RequestBody Item newItem) { ... }
}
