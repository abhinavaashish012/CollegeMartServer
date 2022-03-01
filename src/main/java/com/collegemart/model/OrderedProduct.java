package com.collegemart.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
@Entity
@Setter
@Getter
public class OrderedProduct { //ek product kitne qty me order hua

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedProductId;

    private Integer quantityOrdered;
//
//    @ManyToOne
//    private ProductInventory product;

    @ManyToMany
    @JoinTable(name = "ordered_product_and_orders_join_table",
            joinColumns = {@JoinColumn(name = "orderedProductId")},
            inverseJoinColumns = {@JoinColumn(name = "orderId")})
    private List<Orders> orders; //kitne orders me hoga

}