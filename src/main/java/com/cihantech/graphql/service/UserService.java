package com.cihantech.graphql.service;

import com.cihantech.graphql.exception.UserNotFoundException;
import com.cihantech.graphql.model.User;
import com.cihantech.graphql.model.UserRequest;
import com.cihantech.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User mot Found"));
    }

    public User createUser(UserRequest userRequest) {
        User user=User.builder()
                .mail(userRequest.getMail())
                .role(userRequest.getRole())
                .username(userRequest.getUsername())
                .build();
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User user=userRepository.findById(userRequest.getId())
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
        user.setMail(userRequest.getMail());
        user.setRole(userRequest.getRole());
        user.setUsername(userRequest.getUsername());
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
