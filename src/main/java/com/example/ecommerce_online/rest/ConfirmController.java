package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ConfirmController {
    private final UserService userService;

    @GetMapping("/confirm/{userId}")
    public String confirmRegistration(Model model, @PathVariable Long userId) {
        User userDto = userService.get(userId);
        userDto.setIsActive(true);
        userService.update(userDto);
        log.info("Confirm for user: {}", userDto.getFirstName());
        model.addAttribute("username", userDto.getFirstName());
        return "confirm";
    }

}
