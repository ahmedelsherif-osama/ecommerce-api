package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.exceptions.ResourceNotFoundException;
import com.ahmed.ecommerce.ecommerce.exceptions.notfound.ProductNotFoundException;
import com.ahmed.ecommerce.ecommerce.product.dto.CreateProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.PatchProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.ProductDto;
import com.ahmed.ecommerce.ecommerce.product.dto.UpdateProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final VariantService variantService;
    public ProductServiceImpl(ProductRepository productRepository, VariantService variantService){
        this.productRepository=productRepository;
        this.variantService=variantService;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        return products.stream().map(ProductMapper::toDto).toList();
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        return ProductMapper.toDto(productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException(productId)));
    }

    @Override
    @Transactional
    public ProductDto create(CreateProductRequest request) {
        if (request.variants() == null || request.variants().isEmpty()) {
            throw new IllegalArgumentException("A product must have at least one variant with a price");
        }

        Product product = productRepository.save(ProductMapper.toEntity(request));

        product.setName(request.name());
        product.setDescription(request.description());

        request.variants().forEach(v -> {
                Variant variant = variantService.create(product, v);
                product.getVariants().add(variant); // attach to product
                    }
                );
        return ProductMapper.toDto(product);
    }
    @Override
    public ProductDto updateFully(UUID productId, UpdateProductRequest request) {
        Product existing = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException(productId));
        ProductMapper.applyUpdate(existing,request);
        return ProductMapper.toDto(productRepository.save(existing));
    }

    @Override
    public ProductDto updatePartially(UUID productId, PatchProductRequest request) {
        Product existing = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException(productId));
        ProductMapper.applyPatch(existing,request);
        return ProductMapper.toDto(productRepository.save(existing));
    }

    @Override
    public void delete(UUID productId) {
        Product existing = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException(productId));
        productRepository.delete(existing);
    }
}
