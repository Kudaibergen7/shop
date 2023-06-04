package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.User;

public interface WhatsAppService {
    String sendToNumber(User user);
}
