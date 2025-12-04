package com.ahmed.ecommerce.ecommerce.customer;

import com.ahmed.ecommerce.ecommerce.customer.dto.CreateCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.customer.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.UpdateCustomerRequest;


public class CustomerMapper {
  public static Customer toEntity (CreateCustomerRequest request){
        Customer customer = new Customer();
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        return  customer;
  }

  public static CustomerDto toDto (Customer customer){
      return new CustomerDto(
              customer.getId(),
              customer.getFirstName(),
              customer.getLastName()
      );
  }

  public static void applyUpdate (Customer existing, UpdateCustomerRequest updateRequest){
        existing.setFirstName(updateRequest.firstName());
        existing.setLastName(updateRequest.lastName());
  }
  public static void applyPatch (Customer existing, PatchCustomerRequest patchRequest){
      if(patchRequest.firstName()!=null) existing.setFirstName(patchRequest.firstName());
      if(patchRequest.lastName()!=null) existing.setLastName(patchRequest.lastName());
  }
}
