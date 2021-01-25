package org.mddarr.ride.request.services.controllers;

import org.mddarr.ride.request.services.dto.auth.AuthenticationResponse;
import org.mddarr.ride.request.services.dto.auth.LoginRequest;
import org.mddarr.ride.request.services.services.auth.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", exposedHeaders = "If-Match")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authorizationService.login(loginRequest);
    }

}
