package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.CreateVariantRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.VariantResponse;

import java.util.List;
import java.util.stream.Collectors;

public class VariantMapper {

    public static List<Variant> toEntityList(List<CreateVariantRequest> variantRequests){
        if (variantRequests == null || variantRequests.isEmpty()) return List.of();
        return variantRequests.stream()
                .map(VariantMapper::toEntity)
                .collect(Collectors.toList());

    }

    public static Variant toEntity(CreateVariantRequest variantRequest) {
        if (variantRequest == null) return null;
        Variant variant = new Variant();
        variant.setPrice(variantRequest.price());
        variant.setAttributes(variantRequest.attributes());
        variant.setDiscountedPrice(variantRequest.discountedPrice());
        variant.setSku(variantRequest.sku());
        variant.setStockCount(variantRequest.stockCount());
        return variant;
    }
    // Map single Variant entity to VariantResponse DTO
    public static VariantResponse toDto(Variant variant) {
        if (variant == null) return null;

        return new VariantResponse(
                variant.getId(),
                variant.getPrice(),
                variant.getDiscountedPrice(),
                variant.getStockCount(),
                variant.getSku(),
                variant.getAttributes()
        );
    }

    // Map a list of Variant entities to a list of VariantResponse DTOs
    public static List<VariantResponse> toDtoList(List<Variant> variants) {
        System.out.println("Variant mapper variants "+variants);

        if (variants == null || variants.isEmpty()) return List.of();

        return variants.stream()
                .map(VariantMapper::toDto)
                .collect(Collectors.toList());
    }
}
