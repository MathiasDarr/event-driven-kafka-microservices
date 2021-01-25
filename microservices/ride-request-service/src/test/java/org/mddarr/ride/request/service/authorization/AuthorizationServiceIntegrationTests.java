package org.mddarr.ride.request.service.authorization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.ride.request.service.dto.auth.RegisterRequest;
import org.mddarr.ride.request.service.repositories.UserRepository;
import org.mddarr.ride.request.service.services.auth.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorizationServiceIntegrationTests {

    @MockBean
    UserRepository userRepository;

    @Autowired
    AuthorizationService authorizationService;

    @Test
    void testPostRider(){
        String firstname = "Charles";
        String lastname = "Woodson";
        String email = "cwoodson@yahoo.com";
        String password = "password";

        RegisterRequest postProviderRequest = RegisterRequest.builder()
                .email(email)
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .build();
        authorizationService.register(postProviderRequest);
    }


}
