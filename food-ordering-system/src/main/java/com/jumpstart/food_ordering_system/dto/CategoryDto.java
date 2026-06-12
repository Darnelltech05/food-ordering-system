package com.jumpstart.food_ordering_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for Category.
 * Purpose: DTOs are used to transfer data between layers (Controller to Service)
 * without exposing the Entity directly. This provides better security and control.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
}