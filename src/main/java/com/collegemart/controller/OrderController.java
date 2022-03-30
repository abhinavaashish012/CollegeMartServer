package com.collegemart.controller;

import com.collegemart.model.Orders;
import com.collegemart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/placeOrder")
    public ResponseEntity<Void> createOrder(@RequestBody Orders newOrder) throws IOException {
        Orders placedOrder = orderService.createOrder(newOrder);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Order created with the id : "+placedOrder.getOrderId());
        headers.setLocation(URI.create("http://localhost:9080/orders/find/"+placedOrder.getOrderId()));
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Optional<Orders>> findOrderById(@PathVariable("id") Long orderID)
    {
        Optional<Orders> findOrder = orderService.getOrderById(orderID);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Fetching the order with id : "+orderID);
        System.out.println(findOrder.get().getOrderId());
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(findOrder);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Orders>> fetchAllOrders()
    {
        List<Orders> allOrders = orderService.getAllOrders();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","All orders");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(allOrders);
    }
}
