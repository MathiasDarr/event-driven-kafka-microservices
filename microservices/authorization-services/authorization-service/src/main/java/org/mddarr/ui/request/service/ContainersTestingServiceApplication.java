package org.mddarr.ui.request.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.security.KeyPair;

@SpringBootApplication
@Controller
@SessionAttributes("authorizationRequest")
@EnableResourceServer
public class ContainersTestingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainersTestingServiceApplication.class, args);
	}



}






