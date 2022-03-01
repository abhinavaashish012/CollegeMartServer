package com.collegemart.service;

import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductInventory> getAllProducts();
    Optional<ProductInventory> getProductByProductId(Long id);
    List<ProductInventory> getProductByCategory(Category category);
    ProductInventory saveProduct(ProductInventory newProduct);
    void updateProduct(Long id, ProductInventory p);
    void deleteProduct(Long id);
}
