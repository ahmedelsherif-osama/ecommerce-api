package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.CreateVariantRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public Variant create(Product product, CreateVariantRequest req) {
        Variant variant = new Variant();
        variant.setId(UUID.randomUUID());
        variant.setProduct(product);
        variant.setPrice(req.price());
        variant.setDiscountedPrice(req.discountedPrice());
        variant.setStockCount(req.stockCount());
        variant.setSku(req.sku());
        variant.setAttributes(req.attributes());
        return variantRepository.save(variant);
    }
}
