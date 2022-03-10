package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
@Entity
@Setter
@Getter
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class OrderedProduct { //ek product kitne qty me order hua

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedProductId;

    private Long quantityOrdered;
//
//    @ManyToOne
//    private ProductInventory product;



//
//    @ManyToMany
//    @JoinTable(name = "ordered_product_and_orders_join_table",
//            joinColumns = {@JoinColumn(name = "orderedProductId")},
//            inverseJoinColumns = {@JoinColumn(name = "orderId")})
//    private List<Orders> orders; //kitne orders me hoga


    // bohot saara ordered_product ek hi order me ho sakta h
    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDEREDPRODUCT_ID")
    private Orders orders;


    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "product_product_id")
    private ProductInventory product;



    @Transient
    public Double getTotalBill()
    {
        return getProduct().getPrice()*getQuantityOrdered();
    }

}