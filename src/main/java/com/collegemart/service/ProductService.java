package com.collegemart.service;

import com.collegemart.model.Category;
import com.collegemart.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> getProductByCategory(Category category);
    Product saveProduct(Product newProduct);
    void updateProduct(Long id, Product p);
    void deleteProduct(Long id);
}
