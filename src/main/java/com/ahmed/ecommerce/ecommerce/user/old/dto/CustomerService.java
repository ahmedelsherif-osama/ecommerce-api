package com.ahmed.ecommerce.ecommerce.user;

import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.user.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UpdateCustomerRequest;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(UUID  customerId);
    CustomerDto create(UserRegistrationRequest request);
    CustomerDto updateFully(UUID  customerId, UpdateCustomerRequest request);
    CustomerDto updatePartially(UUID  customerId, PatchCustomerRequest request);
    void delete(UUID id);

}
