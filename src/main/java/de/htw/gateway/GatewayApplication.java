package de.htw.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r
                        .path("/products/**")
                        .filters(f -> f.prefixPath("/v1"))
                        .uri("http://product-service:8080"))
                .build();
    }
     */

    @GetMapping("/open")
    public @ResponseBody String open() {
        return "unsecured: anyone can access";
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "secured: user and admin only";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "secured: admin only";
    }

}