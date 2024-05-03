package org.example.ecommerceproject.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponeDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> products
}
