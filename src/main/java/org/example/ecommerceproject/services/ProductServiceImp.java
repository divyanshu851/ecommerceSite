package org.example.ecommerceproject.services;

import org.example.ecommerceproject.dtos.FakeStoreProductResponseDTO;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.exception.ProductNotFoundException;
import org.example.ecommerceproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id " + productId)
        );
    }

    @Override
    public Product getProduct(String productName) {
        return productRepository.findProductByTitle(productName);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id " + productId)
        );

        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct.setDescription(updatedProduct.getDescription());
        return savedProduct;
    }

    @Override
    public List<Product> getProducts(double min, double max) {
        return productRepository.findProductByPriceBetween(min, max);
    }


}
