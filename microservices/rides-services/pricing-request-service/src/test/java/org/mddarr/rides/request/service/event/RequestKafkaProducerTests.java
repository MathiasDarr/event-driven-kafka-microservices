package org.mddarr.rides.request.service.event;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.mddarr.rides.event.dto.AvroDriver;
import org.mddarr.rides.event.dto.AvroRideRequest;
import org.mddarr.rides.request.service.Constants;
import org.mddarr.rides.request.service.UatAbstractTest;
import org.mddarr.rides.request.service.models.DriverRequest;
import org.mddarr.rides.request.service.models.RideRequest;
import org.mddarr.rides.request.service.services.driver.AvroDriverProducer;
import org.mddarr.rides.request.service.services.riderequest.AvroRideRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestKafkaProducerTests extends UatAbstractTest {

    @Autowired
    private AvroDriverProducer avroDriverProducer;

    @Autowired
    private AvroRideRequestProducer avroRideRequestProducer;

    @Test
    public void should_send_driver_request() {

        avroDriverProducer.activateDriver(new DriverRequest("driverid","Erik", "Ballard", "Seattle", 2));
        ConsumerRecord<String, AvroDriver> singleRecord = KafkaTestUtils.getSingleRecord(avroDriverConsumer, Constants.DRIVERS_TOPIC);
        assertThat(singleRecord).isNotNull();
    }

    @Test
    public void should_send_ride_request() {
        avroRideRequestProducer.sendRideRequest(new RideRequest("Charles",6, "Ballard", "Seattle"));
        ConsumerRecord<String, AvroRideRequest> singleRecord = KafkaTestUtils.getSingleRecord(rideRequestConsumer, Constants.RIDE_REQUEST_TOPIC);
        assertThat(singleRecord).isNotNull();
    }

}
