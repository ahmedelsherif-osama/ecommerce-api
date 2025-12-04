package com.ahmed.ecommerce.ecommerce.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private StoreWallet wallet;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;


}
