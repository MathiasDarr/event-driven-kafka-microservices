package org.mddarr.ride.request.service.controllers;


import org.mddarr.ride.request.service.services.orders.AvroRideRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideRequestController {

    @Autowired
    AvroRideRequestProducer avroRideRequestProducer;

    @PutMapping("rides/requests")
    public String postOrdersRequest(){
        return "dfd";
    }

}
