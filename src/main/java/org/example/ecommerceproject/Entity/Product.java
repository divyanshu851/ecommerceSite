package org.example.ecommerceproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    private String category;
    @ManyToOne
    private Category category2;
    private String imageURL;
    private double rating;
}
