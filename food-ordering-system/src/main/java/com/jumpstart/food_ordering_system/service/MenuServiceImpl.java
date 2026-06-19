package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Category;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.exception.CategoryNotFoundException;
import com.jumpstart.food_ordering_system.exception.MenuNotFoundException;
import com.jumpstart.food_ordering_system.repository.CategoryRepository;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import com.jumpstart.food_ordering_system.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Response<MenuDto> createMenu(MenuDto dto) {
        // Validate category exists
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(
                        "Category not found with id: " + dto.getCategoryId()));

        // Convert DTO to Entity
        Menu menu = mapToEntity(dto, category);

        // Save to database
        Menu saved = menuRepository.save(menu);

        // Convert back to DTO and return
        MenuDto responseDto = mapToDto(saved);
        return Response.success("Menu created successfully", responseDto);
    }

    @Override
    public Response<List<MenuDto>> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();

        List<MenuDto> menuDtos = menus.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return Response.success("Menus retrieved successfully", menuDtos);
    }

    @Override
    public Response<MenuDto> getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));

        MenuDto dto = mapToDto(menu);
        return Response.success("Menu retrieved successfully", dto);
    }

    // ========== PRIVATE MAPPER METHODS ==========

    /**
     * Convert Menu entity to MenuDto
     */
    private MenuDto mapToDto(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .imageUrl(menu.getImageUrl())
                .categoryId(menu.getCategory().getId())
                .categoryName(menu.getCategory().getName())
                .build();
    }

    /**
     * Convert MenuDto to Menu entity
     */
    private Menu mapToEntity(MenuDto dto, Category category) {
        return Menu.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .category(category)
                .build();
    }
}