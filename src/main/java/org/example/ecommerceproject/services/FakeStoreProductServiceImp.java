package org.example.ecommerceproject.services;

import org.example.ecommerceproject.client.FakeStoreClient;
import org.example.ecommerceproject.dtos.FakeStoreProductResponseDTO;
import org.example.ecommerceproject.exception.ProductNotFoundException;
import org.example.ecommerceproject.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImp{
    @Autowired
    private FakeStoreClient client;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = client.getAllProducts();
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreProductResponseDTO product = client.getProductById(productId);
        if(product == null){
            throw new ProductNotFoundException("Product not found with id " + productId);
        }
        return product;
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
