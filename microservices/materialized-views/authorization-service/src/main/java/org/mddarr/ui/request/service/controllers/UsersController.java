package org.mddarr.ui.request.service.controllers;


import org.mddarr.ui.request.service.security.ApplicationUserDetails;
import org.mddarr.ui.request.service.models.AuthenticationRequest;
import org.mddarr.ui.request.service.models.AuthenticationResponse;
import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.models.requests.PostUserRequest;
import org.mddarr.ui.request.service.services.UserService;
import org.mddarr.ui.request.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private ApplicationUserDetails userDetailsService;

    @GetMapping("/api/hello" )
    public String firstPage() {
        return "Hello World";
    }


    @GetMapping(value = "/api/users/all")
    public List<UserEntity> getAllUsers(){
        return userService.getUsers();
    }


    @GetMapping(value="/api/users/{userid}")
    public List<UserEntity> getUserDetail(String userid){
        return userService.getUserById(userid);
    }

    @PutMapping(value = "/api/users")
    public String postUser(@RequestBody  PostUserRequest postUserRequest){
        return userService.postUser(postUserRequest);
    }

    @PostMapping(value = "/api/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
