package com.collegemart.repository;
import com.collegemart.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Optional<Product> findById(Long id);

    Optional<Product> findByCategory(String category);

    List<Product> findAll();

    Product save(Product newProduct);

    void deleteById(Long id);

}


//    Boolean existsByName(String name);
//
//    List<Product> findByCategoryName(String name);