package com.company.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public  static final Contact DEFAULT_CONTACT = new Contact("Sanjay Gonsalves","http://www.thinkbrain.com",
            "thinkbrain@mail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("MonthandMath","Converts the Monthe and do math operations","1.0",
            "urn:tos",DEFAULT_CONTACT, "MonthAndMath 1.0","http://www.thinkbrain.com/license-1.0", Arrays.asList());
    public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
