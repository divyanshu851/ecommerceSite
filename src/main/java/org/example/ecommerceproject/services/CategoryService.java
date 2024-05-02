package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;

import java.util.UUID;

public interface CategoryService {
    Category getCategory(UUID categoryId);
}
