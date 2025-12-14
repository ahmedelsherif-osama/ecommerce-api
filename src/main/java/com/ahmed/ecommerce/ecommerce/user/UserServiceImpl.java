package com.ahmed.ecommerce.ecommerce.user;


import com.ahmed.ecommerce.ecommerce.exceptions.notfound.UserNotFoundException;
import com.ahmed.ecommerce.ecommerce.user.dto.PatchUserRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UpdateUserRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UserDto;
import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDto getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.toDto(user);
    }

    @Override
    public User create(UserRegistrationRequest request) {
        User user = UserMapper.toEntity(request);
        return userRepository.save(user);
    }

    @Override
    public UserDto updateFully(UUID id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        UserMapper.applyUpdate(user, request);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto updatePartially(UUID id, PatchUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        UserMapper.applyPatch(user, request);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with these credentials"));
    }
    @Override
    public User findById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with these credentials"));
    }
}
