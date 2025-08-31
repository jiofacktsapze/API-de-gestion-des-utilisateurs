package com.userManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.userManagment")
public class GestionDesUtilisateursApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesUtilisateursApplication.class, args);
	}

}
