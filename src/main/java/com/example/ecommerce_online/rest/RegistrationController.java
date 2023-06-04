package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.model.request.CreateUserRequest;
import com.example.ecommerce_online.service.UserService;
import com.example.ecommerce_online.service.WhatsAppService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/api/user/register")
@RequiredArgsConstructor
@SecurityRequirement(name = "shop")
public class RegistrationController {

    private final UserService userService;
    private final WhatsAppService whatsAppService;

    @PreAuthorize("hasAuthority('CLIENT')")
    @PostMapping("/")
    public User registerUser(@Valid @RequestBody CreateUserRequest request) {
        User register = userService.register(request);
        whatsAppService.sendToNumber(register);

        return register;
    }

}
