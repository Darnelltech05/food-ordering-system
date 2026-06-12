package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for Category.
 * Responsibilities:
 * - Inject CategoryRepository to access database
 * - Retrieve categories from the database
 * - Convert Category entities into CategoryDto objects
 * - Return a list of CategoryDto objects
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements com.jumpstart.food_ordering_system.service.CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<com.jumpstart.food_ordering_system.dto.CategoryDto> getAllCategories() {
        // Retrieve all categories from database
        List<Category> categories = categoryRepository.findAll();

        // Convert each Category entity to CategoryDTO and return the list
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Helper method to convert Category Entity to CategoryDto
     */
    private com.jumpstart.food_ordering_system.dto.CategoryDto convertToDTO(Category category) {
        return new com.jumpstart.food_ordering_system.dto.CategoryDto(category.getId(), category.getName());
    }
}