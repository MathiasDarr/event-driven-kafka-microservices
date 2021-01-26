package org.mddarr.ride.request.services.authorization;


import org.junit.jupiter.api.Test;
import org.mddarr.ride.request.services.dto.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MvcResult;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorizationApiTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testUnAuthorizedRequestReturns403() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.exchange(
                RequestEntity.get(URI.create("/rides/requests")).header(HttpHeaders.ORIGIN, "http://localhost:8080").build(),
                String.class);
        assertNotEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("http://localhost:8080", entity.getHeaders().getAccessControlAllowOrigin());
    }

    @Test
    public void testAuthorizedRequest(){
        RegisterRequest registerRequest = RegisterRequest.builder()
                .firstname("Charles")
                .lastname("Woods")
                .email("cwoods@gmail.com")
                .password("password")
                .build();
    }


}
