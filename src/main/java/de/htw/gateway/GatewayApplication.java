package de.htw.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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