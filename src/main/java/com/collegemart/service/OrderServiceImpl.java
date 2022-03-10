package com.collegemart.service;

import com.collegemart.model.OrderedProduct;
import com.collegemart.model.Orders;
import com.collegemart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public ResponseEntity<String> createOrder(Orders order) {
        try {
            Orders newOrder = new Orders();

            List<OrderedProduct> orderProducts = order.getOrderedProductList();

            String userEmail = order.getUserEmail();
            Double totalPrice = order.setBill();

            newOrder.setUserEmail(userEmail);
            newOrder.setBill(totalPrice);
            newOrder.setOrderedProductList(orderProducts);
            orderRepository.save(newOrder);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Order has been created!(" + HttpStatus.CREATED + ")");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "This order cannot be created!", e);
        }
    }

}
