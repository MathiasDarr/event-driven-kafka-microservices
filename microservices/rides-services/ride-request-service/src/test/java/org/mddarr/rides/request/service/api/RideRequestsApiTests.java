package org.mddarr.rides.request.service.api;

import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.rides.event.dto.AvroRideRequest;
import org.mddarr.rides.request.service.Constants;
import org.mddarr.rides.request.service.RideRequestApplication;
import org.mddarr.rides.request.service.UatAbstractTest;
import org.mddarr.rides.request.service.services.driver.AvroDriverProducer;
import org.mddarr.rides.request.service.services.riderequest.AvroRideRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


public class RideRequestsApiTests extends UatAbstractTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_acitvate_driver() throws Exception {
        MvcResult activate_driver_result = mockMvc.perform(put("/drivers/activate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"first_name\": \"Guideon\", \"last_name\": \"Jordan\", \"driverid\": \"driver12\",\"city\": \"Seattle\",\"seats\": 2  }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void test_user_posts_ride_request() throws Exception {
        MvcResult user_ride_request_result = mockMvc.perform(put("/rides/request")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"userid\": \"userid1\", \"riders\": 2, \"destination\": \"Ballard\",\"city\": \"Seattle\"  }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        Thread.sleep(200);
//        ConsumerRecord<String, AvroRideRequest> singleRecord = KafkaTestUtils.getSingleRecord(rideRequestConsumer, Constants.RIDE_REQUEST_TOPIC);
//        assertThat(singleRecord).isNotNull();
    }

}