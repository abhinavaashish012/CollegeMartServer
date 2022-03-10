package com.collegemart.repository;

import com.collegemart.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    Orders getById(Long orderId);

    List<Orders> getAllOrderByUserEmail(String userEmail);


}
