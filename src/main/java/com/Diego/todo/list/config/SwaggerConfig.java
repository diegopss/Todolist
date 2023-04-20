package com.Diego.todo.list.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "TodoList - Rest API",
                description = "API exemplo de uso de Springboot REST API",
                version = "1.0",
                termsOfService = "Termo de uso: Open Source",
                contact = @Contact(
                        name = "Diego Passos de Sales",
                        email = "die-gops@hotmail.com"
                )
        )
)
public class SwaggerConfig {
}
