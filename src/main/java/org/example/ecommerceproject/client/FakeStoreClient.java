package org.example.ecommerceproject.client;

import org.example.ecommerceproject.dtos.fakeStoreDTOs.FakeStoreCartResponseDTO;
import org.example.ecommerceproject.dtos.fakeStoreDTOs.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.products.path}")
    private String fakeStoreApiProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICart;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreApiProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String fakeStoreGetProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreApiProductPath).concat("/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreGetProductURL, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId){
        String fakeStoreGetCartURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPICart).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse = restTemplate.getForEntity(fakeStoreGetCartURL, FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }

}
