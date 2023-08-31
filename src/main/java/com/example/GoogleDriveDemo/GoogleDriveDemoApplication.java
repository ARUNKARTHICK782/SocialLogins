package com.example.GoogleDriveDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class GoogleDriveDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(GoogleDriveDemoApplication.class, args);
	}
}
