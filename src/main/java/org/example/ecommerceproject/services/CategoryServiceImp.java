package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.dtos.CategoryResponseDTO;
import org.example.ecommerceproject.dtos.CreateCategoryRequestDTO;
import org.example.ecommerceproject.exception.CategoryNotFoundException;
import org.example.ecommerceproject.mapper.CategoryEntityDTOMapper;
import org.example.ecommerceproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        Category category =  categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("No category found with id" + categoryId)
        );
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for(Category category : categories){
            categoryResponseDTOS.add(CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(category));
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(UUID categoryId, CreateCategoryRequestDTO categoryRequestDTO) {
        Category category =  categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("No category found with id" + categoryId)
        );
        category.setName(categoryRequestDTO.getCategoryName());
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryEntityToCategoryResponseDTO(category);
    }

    @Override
    public Boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }

    @Override
    public Double getTotalPriceForAllProducts(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("The category not found with categoryId" + categoryId)
        );

        if(category.getProducts().isEmpty()){
            return 0.0;
        }else{
            double sum = 0;
            for(Product product : category.getProducts()){
                sum+= product.getPrice();
            }
            return sum;
        }
    }
}
