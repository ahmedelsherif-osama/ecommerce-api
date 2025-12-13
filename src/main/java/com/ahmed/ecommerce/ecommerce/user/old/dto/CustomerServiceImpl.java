package com.ahmed.ecommerce.ecommerce.user;

import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.CustomerDto;
import com.ahmed.ecommerce.ecommerce.user.dto.PatchCustomerRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UpdateCustomerRequest;

import com.ahmed.ecommerce.ecommerce.exceptions.notfound.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements UserService {
    private final UserRepository customerRepository;
    public UserServiceImpl(UserRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> customers =  customerRepository.findAll();
        return customers.stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDto getUserById(UUID customerId) {
        return UserMapper.toDto(customerRepository.findById(customerId).orElseThrow(()-> new UserNotFoundException(customerId)));
    }

    @Override
    public UserDto create(UserRegistrationRequest request) {
        return UserMapper.toDto(customerRepository.save(UserMapper.toEntity(request)));
    }

    @Override
    public UserDto updateFully(UUID customerId, UpdateUserRequest request) {
        User existing = customerRepository.findById(customerId).orElseThrow(()->new UserNotFoundException(customerId));
        UserMapper.applyUpdate(existing,request);
        return UserMapper.toDto(customerRepository.save(existing));
    }

    @Override
    public UserDto updatePartially(UUID customerId, PatchUserRequest request) {
        User existing = customerRepository.findById(customerId).orElseThrow(()->new UserNotFoundException(customerId));
        UserMapper.applyPatch(existing,request);
        return UserMapper.toDto(customerRepository.save(existing));
    }

    @Override
    public void delete(UUID customerId) {
        User existing = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException(customerId));
        customerRepository.delete(existing);
    }
}
