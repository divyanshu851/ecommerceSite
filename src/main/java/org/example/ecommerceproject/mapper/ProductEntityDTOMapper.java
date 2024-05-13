package org.example.ecommerceproject.mapper;

import org.example.ecommerceproject.dtos.ProductRequestDTO;
import org.example.ecommerceproject.dtos.ProductResponseDTO;
import org.example.ecommerceproject.Entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setProductId(product.getId());
        return productResponseDTO;
    }

    public static Product convertCreateProductRequestDTOToProduct(ProductRequestDTO requestDTO){
        Product product = new Product();
        product.setTitle(requestDTO.getTitle());
        product.setRating(0);
        product.setPrice(requestDTO.getPrice());
        product.setDescription(requestDTO.getDescription());
        product.setImageURL(requestDTO.getImageURL());
        return product;
    }
}
