package com.collegemart.controller;
import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;
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
    public List<ProductInventory> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping(path="/{id}")
    public Optional<ProductInventory> getProductById(@PathVariable("id") Long productID)
    {
        return productService.getProductByProductId(productID);
    }

    @GetMapping(path="/find")
    public List<ProductInventory> getProductsAcc2Category(@RequestParam("category") Category category)
    {
        return productService.getProductByCategory(category);
    }

    @PostMapping(path="")
    public ProductInventory addProduct(@RequestBody ProductInventory product)
    {
        System.out.println("product name :"+ product.getName());
        System.out.println("product price :"+ product.getPrice());
        System.out.println("product description :"+ product.getDescription());
        System.out.println("product quantity :"+ product.getAvailableQty());
        System.out.println("product category :"+ product.getCategory());

        return productService.saveProduct(product);
    }

    @PutMapping(path="/{id}")
    public Optional<ProductInventory> updateProduct(@PathVariable("id") Long productID, @RequestBody ProductInventory product)
    {
        Optional<ProductInventory> p = productService.getProductByProductId(productID);
        if(p!=null)
        {
            productService.updateProduct(productID,product);
        }
        return p;
    }

    @DeleteMapping(path="/{id}")
    public void deleteProduct(@PathVariable("id") Long productId)
    {
        Optional<ProductInventory> p = productService.getProductByProductId(productId);
        if(p!=null)
        {
            productService.deleteProduct(productId);
        }
    }
}
