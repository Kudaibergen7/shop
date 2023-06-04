package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.config.WhatsAppConfig;
import com.example.ecommerce_online.model.entity.User;
import com.example.ecommerce_online.service.WhatsAppService;
import com.example.ecommerce_online.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    private final WhatsAppConfig whatsAppConfig;
    private final MessageUtils messageUtils;
    @Override
    public String sendToNumber(User user) {
        whatsAppConfig.sendMessage(user.getPhoneNumber(), messageUtils.registerUserMessage(user));
        return "OK";
    }
}
