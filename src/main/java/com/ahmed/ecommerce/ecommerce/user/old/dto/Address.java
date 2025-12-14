package com.ahmed.ecommerce.ecommerce.user.old.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private Integer buildingNumber;
    private String street;
    private String area;
    private String city;
    private String countryCode;
    private String postCode;
    private String extraDetails;

    private boolean isMainAddress;

    @ManyToOne()
    private User user;

}
