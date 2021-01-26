package org.mddarr.ride.request.services.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.mddarr.ride.request.services.dto.rideshare.DriverRequest;
import org.mddarr.ride.request.services.services.orders.AvroRideRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideRequestController {

	@Autowired
	AvroRideRequestProducer avroRideRequestProducer;

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/rides/requests")
	public String greeting() {
		return "Hello";
	}

	@GetMapping("/rides/users")
	public String greetingWithJavaconfig() {
		System.out.println("==== in greeting ====");

		DriverRequest driverRequest = DriverRequest.builder()
				.city("Seattle")
				.driverid("driver1")
				.first_name("Mario")
				.last_name("Williams")
				.seats(2)
				.build();
		avroRideRequestProducer.sendRideRequest(driverRequest);
		return "df";
	}

	@GetMapping("/rides/bad")
	public String bad() {
		System.out.println("==== in greeting ====");
		return "YOU BAD";
	}


}
