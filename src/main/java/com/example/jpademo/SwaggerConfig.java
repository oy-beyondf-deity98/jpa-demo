package com.example.jpademo;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){

        String jwtSchemeName = "jwtAuth";

        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("basic")
                        .bearerFormat("basicAuth")); // 토큰 형식을 지정하는 임의의 문자(Optional)
//                        .scheme("bearer")
//                        .bearerFormat("JWT")); // 토큰 형식을 지정하는 임의의 문자(Optional)


        return new OpenAPI().info(apiInfo()).addSecurityItem(securityRequirement)
                .components(components);

    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(true) // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404) 등의 노출 여부
//                .apiInfo(apiInfo()) // Swagger UI 로 노출할 정보
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.jpademo.api")) // api 스펙이 작성되어 있는 패키지 (controller)
//                .paths(PathSelectors.any()) // apis 에 위치하는 API 중 특정 path 를 선택
//                .build();
//    }
//
    public Info apiInfo() {
        return new Info()
                .title("SpringBoot Practice Rest API Documentation")
                .description("springboot rest api practice.")
                .version("0.1");

    }
}
