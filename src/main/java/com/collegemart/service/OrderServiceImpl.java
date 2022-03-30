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
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //to fetch the product id and thereby its cost
    @Autowired
    private ProductService productService;

    @Transactional
    public Orders createOrder(Orders order) {
        try {
            Orders newOrder = new Orders();

            List<OrderedProduct> orderProducts = order.getOrderedProductList();

            String userEmail = order.getUserEmail();
            System.out.println("Inside OrderService ");
            System.out.println("Bill : " + order.getBill());
            System.out.println("The number of ordered products are as follows : "+ orderProducts.size());

            //Bill needs to be calculated for each of the product
            Double totalPrice=0D;

            for(int i=0;i<orderProducts.size();i++)
            {
                Long pID=orderProducts.get(i).getProductId();
                if (pID == null) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "This order cannot be created!");
                }
                Long qty= orderProducts.get(i).getQuantityOrdered();
                System.out.println("Product ID : " + pID);
                totalPrice+= productService.getProductPrice(pID)*qty;
            }


            newOrder.setUserEmail(userEmail);
            System.out.println("Useremail set for new order");

            newOrder.setBill(totalPrice);
            System.out.println("bill set for new order = "+totalPrice);

            newOrder.setOrderedProductList(orderProducts);
            System.out.println("OrderedProductList set for new order");

            newOrder.setOrderDate(order.getOrderDate());
            System.out.println("OrderDate set for new order");

            newOrder.setDeliveryDate(order.getDeliveryDate());
            System.out.println("DeliveryDate set for new order");

            orderRepository.save(newOrder);
            System.out.println("neworder saved");

            System.out.println("*******************************************************************");
            return newOrder;
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body("Order has been created!(" + HttpStatus.CREATED + ")");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "This order cannot be created!", e);
        }
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        Orders o = orderRepository.findById(id).get();
        return Optional.of(o);
    }

    @Override
    public List<Orders> getAllOrders()
    {
        return orderRepository.findAll();
    }

}
