package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id" ,nullable = false)
//    private User user;
    private String userEmail;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date orderDate;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date deliveryDate;

    private BigDecimal bill;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "orders")
    private List<OrderedProduct> orderedProductList;
}








//
//    private AtomicInteger orderedQty;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id" ,nullable = false)
//    private User user;
//
//    @ManyToMany(mappedBy = "orders")
//    private List<Product> orderProduct;
////    @JoinTable(name = "orders_product_join_table",
////            joinColumns = {@JoinColumn(name = "id")},
////            inverseJoinColumns = {@JoinColumn(name = "orderId")})