package com.ahmed.ecommerce.ecommerce.customer;

import com.ahmed.ecommerce.ecommerce.customer.dto.CreateCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.customer.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.UpdateCustomerRequest;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(UUID  customerId);
    CustomerDto create(CreateCustomerRequest request);
    CustomerDto updateFully(UUID  customerId, UpdateCustomerRequest request);
    CustomerDto updatePartially(UUID  customerId, PatchCustomerRequest request);
    void delete(UUID id);

}
