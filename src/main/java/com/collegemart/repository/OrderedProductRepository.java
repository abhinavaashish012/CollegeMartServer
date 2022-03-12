//package com.collegemart.repository;
//
//import com.collegemart.model.OrderedProduct;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface OrderedProductRepository extends JpaRepository<OrderedProduct,Long> {
//    List<OrderedProduct> findAllByOrderId(Long id);
//
//
////    @Query("select op.id, op.quantity, p.name from OrderedProduct as op inner join ProductInventory as p on op.id = p.id where op.order = :id")
////    List<OrderedProduct> findOrderProducts(Long id);
//}
