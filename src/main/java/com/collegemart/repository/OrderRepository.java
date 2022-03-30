package com.collegemart.repository;

import com.collegemart.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    Optional<Orders> findById(Long orderId);

    List<Orders> getAllOrderByUserEmail(String userEmail);

}
