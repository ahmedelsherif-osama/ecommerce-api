package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.CreateProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.PatchProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.ProductDto;
import com.ahmed.ecommerce.ecommerce.product.dto.UpdateProductRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(UUID productId);
    ProductDto create(CreateProductRequest request);
    ProductDto updateFully(UUID productId, UpdateProductRequest request);
    ProductDto updatePartially(UUID productId, PatchProductRequest request);
    void delete(UUID id);


}
