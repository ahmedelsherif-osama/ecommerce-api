package com.ahmed.ecommerce.ecommerce.user;


import com.ahmed.ecommerce.ecommerce.user.dto.PatchUserRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UpdateUserRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UserDto;
import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(UUID id);
    User create(UserRegistrationRequest request);
    UserDto updateFully(UUID id, UpdateUserRequest request);
    UserDto updatePartially(UUID id, PatchUserRequest request);
    void delete(UUID id);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findById(UUID userId);
}
