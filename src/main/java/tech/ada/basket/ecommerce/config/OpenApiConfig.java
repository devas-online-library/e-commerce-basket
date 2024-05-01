package tech.ada.basket.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI defaultOpenApiConfig() {
        return new OpenAPI()
                .info(new Info().title("Basket Service")
                        .description("Description ")
                        .version("0.0.1"));
    }
}