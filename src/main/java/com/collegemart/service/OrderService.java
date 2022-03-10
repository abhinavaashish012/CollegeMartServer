package com.collegemart.service;

import com.collegemart.model.Orders;
import org.springframework.http.ResponseEntity;


public interface OrderService {

    ResponseEntity<String> createOrder(Orders order);
}
