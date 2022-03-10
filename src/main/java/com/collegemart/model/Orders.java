package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "customer_id" ,nullable = false)
//    private User user;
    private String userEmail;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date orderDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date deliveryDate;

    private Double bill;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "orders")
    private List<OrderedProduct> orderedProductList = new ArrayList<>();



    @Transient
    public Double setBill() {
        double sum = 0D;
        List<OrderedProduct> orderProducts = getOrderedProductList();
        for (OrderedProduct op : orderProducts) {
            sum += op.getTotalBill();
        }
        return sum;
    }
}




//@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)



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