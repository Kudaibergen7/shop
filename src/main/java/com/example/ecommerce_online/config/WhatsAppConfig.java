package com.example.ecommerce_online.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WhatsAppConfig {

    @Value("${whatsapp.instance.chat-url}")
    private String chatUrl;
    @Value("${whatsapp.instance.token}")
    private String token;

    WebClient webClient = WebClient.create();

    public ResponseEntity<String> sendMessage(String to, String message) {
        String url = String.format("%s?token=%s&to=%s&body=%s", chatUrl, token, to, message);
        return webClient.post()
                .uri(url)
                .header("content-type", "application/x-www-form-urlencoded")
                .retrieve()
                .toEntity(String.class)
                .block();

    };

}
