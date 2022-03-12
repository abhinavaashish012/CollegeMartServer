package com.collegemart.model;

import lombok.*;
import javax.persistence.*;

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
}
