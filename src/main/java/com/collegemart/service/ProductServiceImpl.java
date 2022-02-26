package com.collegemart.service;

import com.collegemart.model.Product;
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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public Optional<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void updateProduct(Long id , Product product) {
        Optional<Product> p = productRepository.findById(id);
        if(p!=null)
        {
            p.get().setName(product.getName());
            p.get().setCategory(product.getCategory());
            p.get().setDescription(product.getDescription());
            p.get().setPrice(product.getPrice());
            productRepository.save(p.get());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> p = productRepository.findById(id);
        if(p!=null)
        {
            productRepository.deleteById(id);
        }
    }
}
