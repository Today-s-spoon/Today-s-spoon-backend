package com.example.todaySpoon.SwaggerConfig;
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
                        .title("오늘의 숟가락 API")
                        .version("v1.0.0")
                        .description("오늘의 숟가락 API 입니다")
                );
    }
}
