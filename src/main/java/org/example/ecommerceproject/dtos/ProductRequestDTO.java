package org.example.ecommerceproject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private String imageURL;
    private String categoryId;
}
