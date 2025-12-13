package com.ahmed.ecommerce.ecommerce.user;

import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.user.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    public CustomerDto create(@RequestBody UserRegistrationRequest request){
        return customerService.create(request);
    }


    @PutMapping("/{id}")
    public CustomerDto update(@PathVariable UUID id,@Valid @RequestBody UpdateCustomerRequest request){
        return customerService.updateFully(id,request);
    }

    @PatchMapping("{id}")
    public  CustomerDto patch(@PathVariable UUID id, @RequestBody PatchCustomerRequest request){
        return customerService.updatePartially(id, request);
    }

    @GetMapping
    public List<CustomerDto> getAll(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable UUID id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        customerService.delete(id);
    }
}
