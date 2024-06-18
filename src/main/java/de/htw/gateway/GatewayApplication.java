package de.htw.gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

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

