package com.dlice.hello.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Date: 2020/9/2 23:29
 * @Author: dlice
 */
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("first", "first"), this.getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hello"))
                .paths(PathSelectors.any())
                .build();
    }

    private Tag[] getTags() {
        return new Tag[]{
                new Tag("uCenter", "用户中心"),
        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hello web api")
                //.description("")
//                .termsOfServiceUrl("/")
                .version("2.6.1")
                .build();
    }

}
