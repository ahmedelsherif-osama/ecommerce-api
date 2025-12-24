package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.*;

import java.util.List;

public class ProductMapper {
  public static Product toEntity (CreateProductRequest request){
        Product product = new Product();
        product.setName(request.name());
        return  product;
  }

  public static ProductDto toDto (Product product){
      return new ProductDto(
              product.getId(),
              product.getName(),
              VariantMapper.toDtoList(product.getVariants())
      );
  }

  public static void applyUpdate (Product existing, UpdateProductRequest updateRequest){
        existing.setName(updateRequest.name());
  }
  public static void applyPatch (Product existing, PatchProductRequest patchRequest){
      if(patchRequest.name()!=null) existing.setName(patchRequest.name());
  }
}
