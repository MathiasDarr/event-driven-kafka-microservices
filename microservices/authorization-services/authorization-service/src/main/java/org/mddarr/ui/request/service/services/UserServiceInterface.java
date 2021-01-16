package org.mddarr.ui.request.service.services;

import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.models.requests.PostUserRequest;


import java.util.List;

public interface UserServiceInterface {

    List<UserEntity> getUserById(String userid);
    String postUser(PostUserRequest postUserRequest);


}
