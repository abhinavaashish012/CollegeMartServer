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

//    @Autowired
//    private OrderedProductRepository orderedProductRepository;

    @Autowired
    private ProductService productService;


    @Transactional
    public ResponseEntity<String> createOrder(Orders order) {
        try {
            Orders newOrder = new Orders();

            List<OrderedProduct> orderProducts = order.getOrderedProductList();

            String userEmail = order.getUserEmail();
            System.out.println("Inside OrderService ");
            System.out.println("Bill : " + order.getBill());
            System.out.println("The number of ordered products are as follows : "+ orderProducts.size());
            for(int i=0;i<orderProducts.size();i++)
                System.out.println("Product ID : " + orderProducts.get(i).getProductId());
            //bill needs to be calculated for each of the product

           // @Transient
//    public Double setBill(Orders o) {
//        double sum = 0D;
//        System.out.println("Inside setbill fn :");
//        List<OrderedProduct> orderProducts = o.getOrderedProductList();
//        for (OrderedProduct op : orderProducts) {
//
//            // fetching the price of products
//            Long pId= op.getOrderedProductId();
//
//
//
//             sum += op.getTotalBill();
//        }
//        System.out.println("Calculated the bill : "+ sum);
//        return sum;
//    }
            Double totalPrice = order.getBill();

            newOrder.setUserEmail(userEmail);
            System.out.println("Useremail set for new order");

            newOrder.setBill(totalPrice);
            System.out.println("bill set for new order");

            newOrder.setOrderedProductList(orderProducts);
            System.out.println("OrderedProductList set for new order");

            newOrder.setOrderDate(order.getOrderDate());
            System.out.println("OrderDate set for new order");

            newOrder.setDeliveryDate(order.getDeliveryDate());
            System.out.println("DeliveryDate set for new order");

            //orderedProductRepository.save(order.getOrderedProduct());
            orderRepository.save(newOrder);
            System.out.println("neworder saved");

            System.out.println("=======================");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Order has been created!(" + HttpStatus.CREATED + ")");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "This order cannot be created!", e);
        }
    }

}
