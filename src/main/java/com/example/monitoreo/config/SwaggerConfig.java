package com.example.monitoreo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
public class SwaggerConfig {
   @Bean
   public OpenAPI customOpenAPI(){
    return new OpenAPI()
    .info(new Info()
    .title(" Monitoreos de agua")
    .version("1.0")
    .description("La gestion consiste para el control, registro y de los monitoreos."));

}
}