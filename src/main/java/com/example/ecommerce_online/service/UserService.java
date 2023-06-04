package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.model.request.CreateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    User register(CreateUserRequest request);

    List<User> getAll();

    User get(Long id);

    User update(User request);

    User delete(Long id);

}
