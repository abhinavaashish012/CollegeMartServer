package com.collegemart.service;

import com.collegemart.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product saveProduct(Product newProduct);

    Optional<Product> getProductsByCategory(String category);

    void updateProduct(Long id, Product p);

    void deleteProduct(Long id);
}
