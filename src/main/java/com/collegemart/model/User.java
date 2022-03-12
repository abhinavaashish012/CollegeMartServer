package com.collegemart.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class User {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String userName;

    @Column(name="password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id_fk")
    private Address address;
}
