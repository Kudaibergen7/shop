package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.model.request.CreateUserRequest;
import com.example.ecommerce_online.repository.UserRepository;
import com.example.ecommerce_online.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(CreateUserRequest request) {
        return userRepository.save(User.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .phoneNumber(request.getPhoneNumber())
                        .address(request.getAddress())
                        .paymentDetails(request.getPaymentDetails())
                        .role(request.getRole())
                        .login(request.getLogin())
                        .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User update(User request) {
        return userRepository.save(request);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
}
