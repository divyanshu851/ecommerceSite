package org.example.ecommerceproject.controller;

import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.dtos.ProductRequestDTO;
import org.example.ecommerceproject.dtos.ProductResponseDTO;
import org.example.ecommerceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO requestDTO){
        return ResponseEntity.ok(productService.createProduct(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO product){
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        boolean isDeleted = productService.deleteProduct(id);
        return ResponseEntity.ok(isDeleted);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable("productName") String productName){
        return ResponseEntity.ok(productService.getProduct(productName));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByPriceRange(@PathVariable("min") double min, @PathVariable("max") double max){
        return ResponseEntity.ok(productService.getProducts(min, max));
    }
}
