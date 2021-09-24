package com.schizhande.usermanagerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.schizhande"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                    "USER MANAGER REST APIS",
                "USER MANAGER . The APIS expose the basic CRUD functionality",
                "1.0.0",
                "Terms of service",
                new Contact("SIMBARASHE SHELDON CHIZHANDE", "+263779914219", "chizhandesheldon689@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
