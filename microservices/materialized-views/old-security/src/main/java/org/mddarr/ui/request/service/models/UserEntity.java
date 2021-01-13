package org.mddarr.ui.request.service.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="users",schema = "users")
public class UserEntity {

    @Id
    private String userid;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date update_ts;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public static UserEntity createDriver(String first_name, String last_name, String email, String encodedPassword) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.DRIVER);
        return new UserEntity(UUID.randomUUID().toString(), first_name, last_name, email, encodedPassword, new Date(System.currentTimeMillis()), roles);
    }
    public static UserEntity createRider(String first_name, String last_name, String email, String encodedPassword){
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.RIDER);
        return new UserEntity(UUID.randomUUID().toString(), first_name, last_name,email,encodedPassword ,new Date(System.currentTimeMillis()),roles);
    }



}
