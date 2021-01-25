package org.mddarr.ride.request.service.controllers;


import org.mddarr.ride.request.service.services.orders.AvroRideRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides/")
public class RideRequestController {

    @Autowired
    AvroRideRequestProducer avroRideRequestProducer;

    @GetMapping("/requests")
    @CrossOrigin(origins = "http://localhost:8080")
    public String postOrdersRequest(){
        return "dfd";
    }

}
