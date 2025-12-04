package com.ahmed.ecommerce.ecommerce.customer;

import com.ahmed.ecommerce.ecommerce.customer.dto.CreateCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.customer.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.customer.dto.UpdateCustomerRequest;

import com.ahmed.ecommerce.ecommerce.exceptions.notfound.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers =  customerRepository.findAll();
        return customers.stream().map(CustomerMapper::toDto).toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerMapper.toDto(customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException(customerId)));
    }

    @Override
    public CustomerDto create(CreateCustomerRequest request) {
        return CustomerMapper.toDto(customerRepository.save(CustomerMapper.toEntity(request)));
    }

    @Override
    public CustomerDto updateFully(UUID customerId, UpdateCustomerRequest request) {
        Customer existing = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
        CustomerMapper.applyUpdate(existing,request);
        return CustomerMapper.toDto(customerRepository.save(existing));
    }

    @Override
    public CustomerDto updatePartially(UUID customerId, PatchCustomerRequest request) {
        Customer existing = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
        CustomerMapper.applyPatch(existing,request);
        return CustomerMapper.toDto(customerRepository.save(existing));
    }

    @Override
    public void delete(UUID customerId) {
        Customer existing = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
        customerRepository.delete(existing);
    }
}
