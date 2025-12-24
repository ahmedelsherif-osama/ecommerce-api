package com.ahmed.ecommerce.ecommerce.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VariantRepository extends JpaRepository<Variant, UUID> {

    // No extra methods needed for now, JpaRepository gives us findById, save, delete, etc.

}
