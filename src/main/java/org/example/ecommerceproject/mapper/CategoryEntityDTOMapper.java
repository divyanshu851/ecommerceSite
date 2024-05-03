package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.dtos.CategoryResponseDTO;
import org.example.ecommerceproject.dtos.ProductResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryEntityToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : category.getProducts()){
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        categoryResponseDTO.setProducts(productResponseDTOS);
        return categoryResponseDTO;
    }
}
