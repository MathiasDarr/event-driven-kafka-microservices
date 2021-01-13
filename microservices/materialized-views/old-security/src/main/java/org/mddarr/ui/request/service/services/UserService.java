package org.mddarr.ui.request.service.services;

import org.mddarr.ui.request.service.models.UserEntity;

import org.mddarr.ui.request.service.models.requests.PostUserRequest;
import org.mddarr.ui.request.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getUserById(String userid) {
        List<UserEntity> userOptional = userRepository.findAll();
        return userOptional;
    }

    @Override
    public String postUser(PostUserRequest postUserRequest) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println("THE CURRENT DATE IS " + date.toString());
        UserEntity user = new UserEntity();
        user.setEmail(postUserRequest.getEmail());
        user.setFirst_name(postUserRequest.getFirst_name());
        user.setLast_name(postUserRequest.getLast_name());
        user.setUserid(UUID.randomUUID().toString());
        user.setPassword(postUserRequest.getPassword());
        user.setUpdate_ts(new Date(System.currentTimeMillis()));
        userRepository.save(user);
        return user.getUserid();
    }
}
