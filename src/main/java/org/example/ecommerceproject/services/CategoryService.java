package org.example.ecommerceproject.services;

import org.example.ecommerceproject.dtos.CategoryResponseDTO;
import org.example.ecommerceproject.dtos.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID categoryId);
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO categoryRequestDTO);
    Boolean deleteCategory(UUID categoryId);
    Double getTotalPriceForAllProducts(UUID categoryId);

}
