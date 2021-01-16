package org.mddarr.user.auth.service.services;

import org.mddarr.user.auth.service.models.UserEntity;
import org.mddarr.user.auth.service.models.requests.PostUserRequest;


import java.util.List;

public interface UserServiceInterface {

    List<UserEntity> getUserById(String userid);
    String postUser(PostUserRequest postUserRequest);


}
