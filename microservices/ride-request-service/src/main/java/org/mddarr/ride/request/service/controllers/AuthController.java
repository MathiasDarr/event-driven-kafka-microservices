package org.mddarr.ride.request.service.controllers;


import lombok.AllArgsConstructor;
import org.mddarr.ride.request.service.dto.auth.*;

import org.mddarr.ride.request.service.services.auth.AuthorizationService;
import org.mddarr.ride.request.service.services.auth.RefreshTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthorizationService authorizationService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/register/driver")
    public ResponseEntity registerDriver(@RequestBody DriverRegistrationRequest registerRequest){
        authorizationService.registerDriver(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest){
        authorizationService.register(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", exposedHeaders = "If-Match")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authorizationService.login(loginRequest);
    }

    @PostMapping("/driver")
    public AuthenticationResponse loginDriver(@RequestBody LoginRequest loginRequest) {
        return authorizationService.login(loginRequest);
    }


    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authorizationService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }


}
