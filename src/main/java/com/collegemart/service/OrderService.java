package com.collegemart.service;

import com.collegemart.exceptions.IdNotFoundException;
import com.collegemart.model.Orders;
import java.util.List;
import java.util.Optional;


public interface OrderService {

    Orders createOrder(Orders order);
    Optional<Orders> getOrderById(Long id) throws IdNotFoundException;
    List<Orders> getAllOrders();

}
