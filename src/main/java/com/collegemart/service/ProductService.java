package com.collegemart.service;

import com.collegemart.exceptions.CategoryNotFoundException;
import com.collegemart.exceptions.IdNotFoundException;
import com.collegemart.exceptions.ProductNotFoundException;
import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductInventory> getAllProducts() throws ProductNotFoundException;

    Optional<ProductInventory> getProductByProductId(Long id) throws IdNotFoundException;

    List<ProductInventory> getProductByCategory(Category category) throws CategoryNotFoundException;

    ProductInventory saveProduct(ProductInventory newProduct);

    void updateProduct(Long id, ProductInventory p);

    void deleteProduct(Long id);

    Double getProductPrice(Long productId);
}
