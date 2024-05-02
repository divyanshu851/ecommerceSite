package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dtos.ProductResponseDTO;
import org.example.ecommerceproject.Entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setDescription(product.getDescription());
        return productResponseDTO;
    }
}
