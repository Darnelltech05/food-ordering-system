package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Category entities.
 * Responsibility: Handles all database operations for Category.
 * Extending JpaRepository provides built-in methods like findAll(), findById(), save(), delete().
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}