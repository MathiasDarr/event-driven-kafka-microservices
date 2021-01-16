package org.mddarr.user.auth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@SessionAttributes("authorizationRequest")
public class ContainersTestingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainersTestingServiceApplication.class, args);
	}



}





