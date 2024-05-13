package org.example.ecommerceproject.services;

import org.example.ecommerceproject.Entity.Category;
import org.example.ecommerceproject.Entity.Product;
import org.example.ecommerceproject.exception.CategoryNotFoundException;
import org.example.ecommerceproject.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CategoryServiceImpTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImp categoryService;

    @BeforeEach
    public void setup(){
        initMocks(this); // now this is not required, it is done before
    }

    @Test
    public void testGetTotalPriceForMultipleProductsUnderCategory(){
        //this method will return the total cost for all products under a category
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockData();
        when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedCost = 300.0;

        //Act
        double actualTotalCost = categoryService.getTotalPriceForAllProducts(categoryId);

        //verify
        assertEquals(actualTotalCost, expectedCost);
    }


    @Test
    public void testGetTotalPriceForZeroProductUnderCategory(){
        //this method will return the total cost for all products under a category
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockDataWithZeroProducts();
        when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedCost = 0.0;

        //Act
        double actualTotalCost = categoryService.getTotalPriceForAllProducts(categoryId);


        //verify
        assertEquals(actualTotalCost, expectedCost);
        verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testCategoryNotFoundExceptionThrown() {
        //Arrange
        UUID categoryId = UUID.randomUUID();
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        //Act and assert
        Assertions.assertThrows(CategoryNotFoundException.class, ()-> categoryService.getTotalPriceForAllProducts(categoryId));
    }

    @Test
    public void testPackage() {
        Package sourcePackage = org.example.ecommerceproject.services.CategoryServiceImp.class.getPackage();
        Package testPackage = org.example.ecommerceproject.services.CategoryServiceImpTest.class.getPackage();

        assertEquals(sourcePackage.getName(), testPackage.getName());
    }
    public Optional<Category> getCategoryMockDataWithZeroProducts(){
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        List<Product> products = new ArrayList<>();
        category.setProducts(products);
        return Optional.of(category);

    }
    public Optional<Category> getCategoryMockData(){
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.0);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("product2");
        product2.setPrice(200.0);
        product2.setCategory(category);

        List<Product> products = List.of(product1, product2);
        category.setProducts(products);
        return Optional.of(category);   // Optional.of() returns an Optional with the specified present non-null value.
    }
}
