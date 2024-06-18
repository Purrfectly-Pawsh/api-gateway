package de.htw.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service-api", r -> r
                        .path("/product-service-doc/**")
                        .filters(f -> f.rewritePath("/product-service-doc/?(?<segment>.*)", "/${segment}"))
                        .uri("http://product-service:8080"))
                .route("product-service", r -> r
                        .path("/products/**")
                        .filters(f -> f.prefixPath("/v1"))
                        .uri("http://product-service:8080"))
                .route("product-add-to-basket", r -> r.path("/baskets/**")
                        .and().method(HttpMethod.POST)
                        .filters(f -> f.prefixPath("/v1"))
                        .uri("http://product-service:8080"))
                .route("basket-service", r -> r
                        .path("/baskets/**")
                        .and()
                        .method("GET", "DELETE", "PUT")
                        .filters(f -> f.prefixPath("/v1"))
                        .uri("http://basket-service:8080"))
                .build();
    }
}
