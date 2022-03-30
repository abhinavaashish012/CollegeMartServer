package com.collegemart.controller;
import com.collegemart.exceptions.CategoryNotFoundException;
import com.collegemart.exceptions.GlobalExceptionHandler;
import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;
import com.collegemart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/all")
    public ResponseEntity<List<ProductInventory>> getAllProducts()
    {
        List<ProductInventory> productInventoryList = productService.getAllProducts();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("description","Total Products in the Inventory");
        httpHeaders.add("type","Product Inventory");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(productInventoryList);
    }

    @GetMapping(path="/search/{id}")
    public ResponseEntity<Optional<ProductInventory>> getProductById(@PathVariable("id") Long productID)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        Optional<ProductInventory> productInventory = productService.getProductByProductId(productID);

        if (productInventory.isPresent()==false) {
            httpHeaders.add("description","Product with "+ productID+" not present.");
            httpHeaders.add("type","Product Inventory");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).build();
        }
        httpHeaders.add("description","Product with "+ productID);
        httpHeaders.add("type","Product Inventory");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(productInventory);
    }

    @GetMapping(path="/find")
    public ResponseEntity<List<ProductInventory>> getProductsAcc2Category(@RequestParam("category") Category category)  {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Product List for Category "+category);
        httpHeaders.add("type","Product List with Category = "+ category);
        List<ProductInventory> productInventoryList = productService.getProductByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(productInventoryList);
    }

    @PostMapping(path="")
    public ResponseEntity<Void> addProduct(@RequestBody ProductInventory product)
    {
        ProductInventory p = productService.saveProduct(product);
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("desc","Adding the product to inventory with id :"+p.getProductId());
        httpHeaders.setLocation(URI.create("http://localhost:9080/api/product/search/"+p.getProductId()));
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).build();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long productID, @RequestBody ProductInventory product)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Updating the product details with id : "+productID);
        Optional<ProductInventory> p = productService.getProductByProductId(productID);

        if(p!=null)
        {
            productService.updateProduct(productID,product);
        }
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Deleting the Product with id : "+productId);
        Optional<ProductInventory> p = productService.getProductByProductId(productId);
        if(p!=null)
        {
            productService.deleteProduct(productId);
        }
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }
}
