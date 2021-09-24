package com.schizhande.configserverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerServiceApplication.class, args);
    }

}
