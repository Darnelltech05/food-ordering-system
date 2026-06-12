package com.jumpstart.food_ordering_system.exception;

/**
 * Custom exception for Category not found scenarios.
 * Purpose: Custom exceptions provide meaningful error messages specific to our application domain.
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}