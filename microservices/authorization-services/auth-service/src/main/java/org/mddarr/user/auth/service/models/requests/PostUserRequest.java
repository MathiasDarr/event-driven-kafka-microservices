package org.mddarr.user.auth.service.models.requests;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostUserRequest {

    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
