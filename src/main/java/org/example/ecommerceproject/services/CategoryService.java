package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.dtos.CategoryResponeDTO;
import org.example.ecommerceproject.dtos.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponeDTO getCategory(UUID categoryId);
    List<CategoryResponeDTO> getAllCategory();
    CategoryResponeDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponeDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO categoryRequestDTO);
    Boolean deleteCategory(UUID categoryId);
}
