package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class OrderedProduct { //ek product kitne qty me order hua

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Long quantityOrdered;

    // bohot saara ordered_product ek hi order me ho sakta h
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDEREDPRODUCT_ID")
    private Orders orders;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_product_id")
    private ProductInventory product;
}