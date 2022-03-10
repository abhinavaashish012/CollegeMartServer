package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;

    private Double price;

    private Long availableQty;

    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;

//    @ManyToMany
//    @JoinTable(name = "productinventory_orders_join_table",
//            joinColumns = {@JoinColumn(name = "productId")},
//            inverseJoinColumns = {@JoinColumn(name = "orderId")})
//    private List<Orders> orders;
    // @JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
}
