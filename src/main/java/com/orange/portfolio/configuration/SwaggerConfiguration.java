package com.orange.portfolio.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("orange-portfolio")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Orange Portfolio")
                        .version("1.0.0")
                        .description("Documentation Orange Portfolio"));
    }

}
