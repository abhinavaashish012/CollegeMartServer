package com.collegemart.repository;
import com.collegemart.model.Category;
import com.collegemart.model.ProductInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductInventory,Long> {
    Optional<ProductInventory> findByProductId(Long id);
    List<ProductInventory> findByCategory(Category category);
    List<ProductInventory> findAll();
    ProductInventory save(ProductInventory newProduct);
    void deleteByProductId(Long id);
}
