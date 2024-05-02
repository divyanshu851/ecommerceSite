package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.dtos.ProductRequestDTO;
import org.example.ecommerceproject.dtos.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO updateProduct(ProductRequestDTO updatedProduct, UUID productId);
    List<ProductResponseDTO> getProducts(double min, double max);

}
