package com.dreamhouse237.dreamhouse_config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class DreamhouseConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamhouseConfigServiceApplication.class, args);
	}

}
