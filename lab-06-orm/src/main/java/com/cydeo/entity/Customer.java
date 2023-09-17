package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity {


    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Address> addresses;
}
