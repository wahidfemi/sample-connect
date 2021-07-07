package com.mckesson.connect.portal.deleteservice;

import com.mckesson.lib.spring.config.annotation.EnableMCKService;
import com.mckesson.lib.spring.config.annotation.EnableMCKServiceSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMCKService
@EnableMCKServiceSecurity
public class PortalDeleteServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalDeleteServiceApplication.class, args);
    }
}


