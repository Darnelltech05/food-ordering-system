package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.response.Response;
import com.jumpstart.food_ordering_system.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // GET all categories
    @GetMapping
    public ResponseEntity<Response<List<CategoryDto>>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(Response.success("Categories retrieved successfully", categories));
    }

    // GET category by id
    @GetMapping("/{id}")
    public ResponseEntity<Response<CategoryDto>> getCategoryById(@PathVariable Long id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(Response.success("Category retrieved successfully", category));
    }

    // POST - Create new category
    @PostMapping
    public ResponseEntity<Response<CategoryDto>> addCategory(@Valid @RequestBody CategoryDto dto) {
        CategoryDto created = categoryService.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Response.success("Category created successfully", created));
    }

    // PUT - Update category
    @PutMapping("/{id}")
    public ResponseEntity<Response<CategoryDto>> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDto dto) {
        CategoryDto updated = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(Response.success("Category updated successfully", updated));
    }

    // DELETE - Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(Response.success("Category deleted successfully", null));
    }
}