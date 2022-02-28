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
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "pinCode")
    private Long pinCode;

    //@OneToOne(fetch = FetchType.LAZY,optional = false)
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
