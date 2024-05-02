package org.example.ecommerceproject.services;

import org.example.ecommerceproject.dtos.FakeStoreProductResponseDTO;
import org.example.ecommerceproject.Entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId);
    Product getProduct(String productName);
    Product createProduct(Product product);
    boolean deleteProduct(UUID productId);
    Product updateProduct(Product updatedProduct, UUID productId);
    List<Product> getProducts(double min, double max);

}
