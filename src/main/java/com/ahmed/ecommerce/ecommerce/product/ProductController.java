package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.CreateProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.PatchProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.ProductDto;
import com.ahmed.ecommerce.ecommerce.product.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public ProductDto create(@RequestBody CreateProductRequest request){
       return productService.create(request);
    }


    @PutMapping("/{id}")
    public ProductDto update(@PathVariable UUID id,@Valid @RequestBody UpdateProductRequest request){
       return productService.updateFully(id,request);
    }

    @PatchMapping("{id}")
    public  ProductDto patch(@PathVariable UUID id, @RequestBody PatchProductRequest request){
        return productService.updatePartially(id, request);
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable UUID id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        productService.delete(id);
    }
}
