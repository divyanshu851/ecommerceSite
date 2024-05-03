package org.example.ecommerceproject.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductResponseDTO {
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;

}
