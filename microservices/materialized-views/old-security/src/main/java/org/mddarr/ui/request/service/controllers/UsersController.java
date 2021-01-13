package org.mddarr.ui.request.service.controllers;

import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.models.requests.PostUserRequest;
import org.mddarr.ui.request.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping(value="/api/users/{userid}")
    public List<UserEntity> getUserDetail(String userid){
        return userService.getUserById(userid);
    }

    @PutMapping(value = "/api/users")
    public String postUser(@RequestBody  PostUserRequest postUserRequest){
        return userService.postUser(postUserRequest);
    }

}
