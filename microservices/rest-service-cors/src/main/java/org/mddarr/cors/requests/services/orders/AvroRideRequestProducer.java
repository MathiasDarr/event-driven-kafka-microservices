package org.mddarr.cors.requests.services.orders;


import org.mddarr.cors.requests.dto.rideshare.DriverRequest;
import org.mddarr.rides.event.dto.AvroDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class AvroRideRequestProducer implements AvroProducerInterface {


    @Autowired
    private KafkaTemplate<String, AvroDriver> kafkaTemplateEvent1;

    private static final Logger logger = LoggerFactory.getLogger(AvroRideRequestProducer.class);

    public void sendRideRequest(DriverRequest driverRequest) {
        AvroDriver avroDriver = AvroDriver.newBuilder()
                .setFirstname(driverRequest.getFirst_name())
                .setLastname(driverRequest.getLast_name())
                .setDriverid(driverRequest.getDriverid())
                .setSeats(driverRequest.getSeats())
                .build();

    }

}
