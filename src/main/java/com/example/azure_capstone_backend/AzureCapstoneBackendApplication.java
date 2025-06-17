// src/main/java/com/example/azurecapstonebackend/AzureCapstoneBackendApplication.java
package com.example.azurecapstonebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AzureCapstoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureCapstoneBackendApplication.class, args);
	}

	/**
	 * Configures Cross-Origin Resource Sharing (CORS) for the application.
	 * This is crucial for enabling the frontend (running on a different origin/port)
	 * to make API requests to this backend.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**") // Apply CORS rules to all endpoints under /api
						// Specify allowed origins for your frontend.
						// For local development, this typically includes React's default port 3000,
						// or Vite's default 5173, and 127.0.0.1 variants.
						// In production, this should be your frontend's deployed domain.
						.allowedOrigins("http://localhost:3000", "http://localhost:5173", "http://127.0.0.1:3000", "http://127.0.0.1:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true); // Allow sending of cookies and authentication headers
			}
		};
	}
}

