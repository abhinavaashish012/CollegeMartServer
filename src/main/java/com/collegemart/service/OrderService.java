package com.collegemart.service;

import com.collegemart.model.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    Orders createOrder(Orders order);
    Optional<Orders> getOrderById(Long id);
    List<Orders> getAllOrders();

}
