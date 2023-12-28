package com.changeside.mediumDemo;

import com.changeside.mediumDemo.model.Role;
import com.changeside.mediumDemo.model.User;
import com.changeside.mediumDemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class MediumDemoApplication    {

	public static void main(String[] args) {
		SpringApplication.run(MediumDemoApplication.class, args);
	}


}
