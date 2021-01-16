package org.mddarr.user.auth.service.controllers;


import org.mddarr.user.auth.service.models.AuthenticationRequest;
import org.mddarr.user.auth.service.models.AuthenticationResponse;
import org.mddarr.user.auth.service.models.UserEntity;
import org.mddarr.user.auth.service.models.requests.PostUserRequest;
import org.mddarr.user.auth.service.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

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
    public String postUser(@RequestBody PostUserRequest postUserRequest){
        return userService.postUser(postUserRequest);
    }

    @PostMapping(value = "/api/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        return ResponseEntity.ok(new AuthenticationResponse("token"));
    }

}
