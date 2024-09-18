package com.example.cloud.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    /*@Bean
    public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("EUREKA-CLIENT-ACCOUNTS",r->r.path("/graphql/**")
                        .uri("http://localhost:8080/"))
                .route("EUREKA-CLIENT-ADDRESS",r->r.path("/graphql/**")
                        .uri("http://localhost:8081/")).build();
    }*/
}
