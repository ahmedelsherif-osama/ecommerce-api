package com.ahmed.ecommerce.ecommerce.product;

import com.ahmed.ecommerce.ecommerce.product.dto.CreateProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.PatchProductRequest;
import com.ahmed.ecommerce.ecommerce.product.dto.ProductDto;
import com.ahmed.ecommerce.ecommerce.product.dto.UpdateProductRequest;

public class ProductMapper {
  public static Product toEntity (CreateProductRequest request){
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        return  product;
  }

  public static ProductDto toDto (Product product){
      return new ProductDto(
              product.getId(),
              product.getName(),
              product.getPrice()
      );
  }

  public static void applyUpdate (Product existing, UpdateProductRequest updateRequest){
        existing.setName(updateRequest.name());
        existing.setPrice(updateRequest.price());
  }
  public static void applyPatch (Product existing, PatchProductRequest patchRequest){
      if(patchRequest.name()!=null) existing.setName(patchRequest.name());
      if(patchRequest.price()!=null) existing.setPrice(patchRequest.price());
  }
}
