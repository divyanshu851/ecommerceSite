package org.example.ecommerceproject.services;

import org.example.ecommerceproject.client.FakeStoreClient;
import org.example.ecommerceproject.dtos.ProductResponseDTO;
import org.example.ecommerceproject.dtos.fakeStoreDTOs.FakeStoreProductResponseDTO;
import org.example.ecommerceproject.exception.ProductNotFoundException;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.mapper.ProductEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImp{
    @Autowired
    private FakeStoreClient client;

    public List<ProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = client.getAllProducts();
        List<ProductResponseDTO> products = new ArrayList<>();
        for(FakeStoreProductResponseDTO product : fakeStoreProducts){
            products.add(ProductEntityDTOMapper.convertFakeStoreProductToProductResponseDTO(product));
        }
        return products;
    }


    public ProductResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreProductResponseDTO product = client.getProductById(productId);
        if(product == null){
            throw new ProductNotFoundException("Product not found with id " + productId);
        }
        return ProductEntityDTOMapper.convertFakeStoreProductToProductResponseDTO(product);
    }


    public Product createProduct(Product product) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }


    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }
}
