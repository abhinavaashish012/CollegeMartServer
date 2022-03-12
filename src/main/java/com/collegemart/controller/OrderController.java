package com.collegemart.controller;

import com.collegemart.model.Orders;
import com.collegemart.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping(value = "/placeOrder")
    public ResponseEntity<String> createUserRequest(@RequestBody Orders newOrder) throws IOException {
        System.out.println("NewOrder ID = "+ newOrder.getOrderId());
        System.out.println("NewOrder UserEmail = "+ newOrder.getUserEmail());
        System.out.println("NewOrder ORDERDATE = "+ newOrder.getOrderDate());
        System.out.println("NewOrder DELIVERYDATE = "+ newOrder.getDeliveryDate());
        System.out.println("NewOrder BILL = "+ newOrder.getBill());
        System.out.println("NewOrder List = "+ newOrder.getOrderedProductList());

        return orderService.createOrder(newOrder);
    }
}
