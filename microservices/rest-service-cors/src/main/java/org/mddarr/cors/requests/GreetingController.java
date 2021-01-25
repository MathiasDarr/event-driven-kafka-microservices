package org.mddarr.cors.requests;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/rides/requests")
	public String greeting() {
		return "Hello";
	}

	@GetMapping("/rides/users")
	public String greetingWithJavaconfig() {
		System.out.println("==== in greeting ====");
		return "df";
	}

	@GetMapping("/rides/bad")
	public String bad() {
		System.out.println("==== in greeting ====");
		return "YOU BAD";
	}


}
