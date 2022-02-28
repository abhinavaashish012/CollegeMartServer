package com.collegemart.controller;
import com.collegemart.model.Category;
import com.collegemart.model.Product;
import com.collegemart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/all")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping(path="/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long productID)
    {
        return productService.getProductById(productID);
    }

    @GetMapping(path="/find")
    public List<Product> getProductsAcc2Category(@RequestParam("category") Category category)
    {
        return productService.getProductByCategory(category);
    }

    @PostMapping(path="")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    @PutMapping(path="/{id}")
    public Optional<Product> updateProduct(@PathVariable("id") Long productID, @RequestBody Product product)
    {
        Optional<Product> p = productService.getProductById(productID);
        if(p!=null)
        {
            productService.updateProduct(productID,product);
        }
        return p;
    }

    @DeleteMapping(path="/{id}")
    public void deleteProduct(@PathVariable("id") Long productId)
    {
        Optional<Product> p = productService.getProductById(productId);
        if(p!=null)
        {
            productService.deleteProduct(productId);
        }
    }
}
