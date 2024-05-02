package org.example.ecommerceproject.controller;

import org.example.ecommerceproject.client.FakeStoreClient;
import org.example.ecommerceproject.client.FakeStoreClient;
import org.example.ecommerceproject.dtos.FakeStoreCartResponseDTO;
import org.example.ecommerceproject.exception.CartNotFoundException;
import org.example.ecommerceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> carts = fakeStoreClient.getCartByUserId(userId);
        if(carts==null){
            throw new CartNotFoundException("Cart not found for user with id " + userId);
        }
        return ResponseEntity.ok(carts);
    }
}
