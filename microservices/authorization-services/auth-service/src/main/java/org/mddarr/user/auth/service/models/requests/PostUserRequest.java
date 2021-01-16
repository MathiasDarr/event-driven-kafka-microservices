package org.mddarr.user.auth.service.models.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostUserRequest {

    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
