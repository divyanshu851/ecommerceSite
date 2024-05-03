package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.dtos.ProductRequestDTO;
import org.example.ecommerceproject.dtos.ProductResponseDTO;
import org.example.ecommerceproject.exception.CategoryNotFoundException;
import org.example.ecommerceproject.exception.ProductNotFoundException;
import org.example.ecommerceproject.mapper.ProductEntityDTOMapper;
import org.example.ecommerceproject.repositories.CategoryRepository;
import org.example.ecommerceproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : products){
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) {
        Product savedProduct =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id " + productId)
        );
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        Product product =  productRepository.findProductByTitle(productName);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        UUID categoryId = UUID.fromString(productRequestDTO.getCategoryId());
        Category savedCategory =  categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("The category not found with id" + productRequestDTO.getCategoryId())
        );
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        List<Product> temp = savedCategory.getProducts();
        temp.add(product);
        categoryRepository.save(savedCategory);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id " + productId)
        );
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getProducts(double min, double max) {
        List<Product> products =  productRepository.findProductByPriceBetween(min, max);
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product product : products){
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOS;
    }


}
