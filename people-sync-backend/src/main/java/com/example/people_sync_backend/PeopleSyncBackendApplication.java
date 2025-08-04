package com.example.people_sync_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class PeopleSyncBackendApplication {

	@RequestMapping("/")
	public String home() {
		return "Olá mundo";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(PeopleSyncBackendApplication.class, args);
	}

}
