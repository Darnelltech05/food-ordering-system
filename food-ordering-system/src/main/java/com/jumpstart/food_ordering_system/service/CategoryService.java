package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import java.util.List;

/**
 * Service interface defining business operations for Category.
 * The service layer contains business logic and acts as a bridge between Controller and Repository.
 */
public interface CategoryService {
    List<CategoryDto> getAllCategories();
}