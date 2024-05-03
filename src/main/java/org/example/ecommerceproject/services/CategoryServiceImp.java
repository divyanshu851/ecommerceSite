package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.dtos.CategoryResponeDTO;
import org.example.ecommerceproject.dtos.CreateCategoryRequestDTO;
import org.example.ecommerceproject.exception.CategoryNotFoundException;
import org.example.ecommerceproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponeDTO getCategory(UUID categoryId) {
        Category category =  categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("No category found with id" + categoryId)
        );

    }

    @Override
    public List<CategoryResponeDTO> getAllCategory() {
        return null;
    }

    @Override
    public CategoryResponeDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public CategoryResponeDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteCategory(UUID categoryId) {
        return null;
    }
}
