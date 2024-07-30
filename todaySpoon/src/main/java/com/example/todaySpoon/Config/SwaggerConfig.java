package com.example.todaySpoon.Config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("¿À´ÃÀÇ ¼ù°¡¶ô API")
                        .version("v1.0.0")
                        .description("¿À´ÃÀÇ ¼ù°¡¶ô APIÀÔ´Ï´Ù.")
                );
    }
}
