package com.cosmos.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class FilterConfig {
    // @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
            .route(r -> r.path("/api/product/**")
                .filters(f -> f.addRequestHeader("productRequest", "productRequestHeader")
                    .addResponseHeader("productResponse", "productResponseHeader"))
                .uri("http://localhost:8100")
            )
            .route(r -> r.path("/api/order/**")
                .filters(f -> f.addRequestHeader("productRequest", "productRequestHeader")
                    .addResponseHeader("productResponse", "productResponseHeader"))
                .uri("http://localhost:8200")
            )
            .build();
    }
}
