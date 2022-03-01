package com.collegemart.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "pinCode")
    private Long pinCode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private User user;
}
