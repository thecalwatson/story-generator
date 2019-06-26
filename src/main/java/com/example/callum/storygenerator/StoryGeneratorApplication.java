package com.example.callum.storygenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StoryGeneratorApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(StoryGeneratorApplication.class, args);
    }

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.callum.storygenerator.api"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "REST API - story-generator",
                "API exposed by story-generator",
                "1.0",
                "",
                "Callum Watson",
                "",
                "");
        return apiInfo;
    }
}
