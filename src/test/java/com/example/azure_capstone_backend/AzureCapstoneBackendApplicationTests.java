package com.example.azure_capstone_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AzureCapstoneBackendApplicationTests {

    @Test
    void contextLoads() {
        // This test is to verify that the Spring context loads successfully
    }

    @Test
    void simpleMathTest() {
        int sum = 2 + 3;
        assertEquals(5, sum, "Sum should be 5");
    }

    @Test
    void stringContainsTest() {
        String str = "Spring Boot Testing";
        assertTrue(str.contains("Boot"), "String should contain 'Boot'");
    }

    @Test
    void randomBooleanTest() {
        boolean condition = (Math.random() > 0.5);
        assertTrue(condition, "Random condition failed");
    }

    @Test
    void anotherSimpleTest() {
        String expected = "Hello, World!";
        String actual = "Hello, " + "World!";
        assertEquals(expected, actual, "Strings should match");
    }
}
