package com.jumpstart.food_ordering_system.config;

import com.jumpstart.food_ordering_system.entity.Role;
import com.jumpstart.food_ordering_system.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Arrays.asList("ADMIN", "CUSTOMER").forEach(roleName -> {
                Role role = new Role();
                role.setName(roleName);
                roleRepository.save(role);
            });
            System.out.println("✅ Roles seeded: ADMIN, CUSTOMER");
        }
    }
}