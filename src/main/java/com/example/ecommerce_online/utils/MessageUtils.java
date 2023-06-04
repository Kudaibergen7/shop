package com.example.ecommerce_online.utils;

import com.example.ecommerce_online.model.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

    @Value("${link.url}")
    private String linkUrl;

    public String registerUserMessage(User user) {
        return String.format("Добро пожаловать %s %s!\n" +
                "Вы зарегистрированы на сайте нашей компании\n" +
                "Перейдите по ссылке и подтвердите свой личный кабинет: %s\n",
                user.getFirstName(), user.getLastName(), linkUrl + user.getId());
    }

}
