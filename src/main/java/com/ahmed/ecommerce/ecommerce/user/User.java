package com.ahmed.ecommerce.ecommerce.user;

import com.ahmed.ecommerce.ecommerce.payment.PaymentMethodEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private StoreWallet wallet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentMethodEntity> paymentMethods;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;


}
