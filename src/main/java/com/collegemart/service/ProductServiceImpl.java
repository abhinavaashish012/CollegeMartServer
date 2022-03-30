package com.collegemart.service;
import com.collegemart.exceptions.IdNotFoundException;
import com.collegemart.exceptions.ProductNotFoundException;
import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;
import com.collegemart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductInventory> getAllProducts() {

        List<ProductInventory> productInventoryList = productRepository.findAll();
        if (productInventoryList == null) {
            throw new ProductNotFoundException("No products in the inventory...");
        }
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductInventory> getProductByProductId(Long id) {

        if(id < 0 )
        {
            throw new RuntimeException("Exception : Product Id can't be negative....");
        }

        Optional<ProductInventory> p = productRepository.findByProductId(id);
        if (p.isPresent()!=false)
        {
            return p;
        }
        else
            throw new IdNotFoundException("Product with the id : "+id+" does not exist.");
    }

    @Override
    public List<ProductInventory> getProductByCategory(Category category) {
        List<ProductInventory> productInventoryList = productRepository.findByCategory(category);

        if (productInventoryList == null) {
            throw new ProductNotFoundException("Products for this category are not present");
        }
        return productRepository.findByCategory(category);
    }

    @Override
    public ProductInventory saveProduct(ProductInventory newProductInventory) {
        return productRepository.save(newProductInventory);
    }


    @Override
    public void updateProduct(Long id , ProductInventory product) {
        Optional<ProductInventory> p = productRepository.findById(id);
        if(p!=null)
        {
            System.out.println("Inside product service method..........");
            p.get().setName(product.getName());
            p.get().setCategory(product.getCategory());
            p.get().setDescription(product.getDescription());
            p.get().setPrice(product.getPrice());
            productRepository.save(p.get());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<ProductInventory> p = productRepository.findById(id);
        if(p!=null)
        {
            productRepository.deleteById(id);
        }
    }

    @Override
    public Double getProductPrice(Long productId)
    {
        Optional<ProductInventory> p = productRepository.findByProductId(productId);
        if (p == null) {
            return Double.valueOf(0);
        }
        return p.get().getPrice();
    }
}
