package com.example.lares.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Lares"
                ),
                description = "OpenApi documentation for Frontend",
                title = "Lares Project Api",
                version = "1.0",
                termsOfService = "Terms of Service"
        )
)
public class OpenApiConfig {
}
