package com.example.ecommerce_online;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Shop API", version = "2.0", description = ""))
@SecurityScheme(name = "shop", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class ECommerceOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ECommerceOnlineApplication.class, args);
    }

}
