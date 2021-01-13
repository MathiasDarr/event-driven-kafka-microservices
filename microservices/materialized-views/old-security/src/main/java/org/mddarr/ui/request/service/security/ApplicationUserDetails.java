package org.mddarr.ui.request.service.security;

import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.models.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationUserDetails extends User {


    private static final String ROLE_PREFIX = "ROLE_";
    private final String userid;

    public ApplicationUserDetails(UserEntity userEntity){
        super(userEntity.getEmail(), userEntity.getPassword(), createAuthorities(userEntity.getRoles()));
        this.userid = userEntity.getUserid();

    }

    private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole> roles) {
        return roles.stream()
                .map(userRole -> new SimpleGrantedAuthority(ROLE_PREFIX + userRole.name()))
                .collect(Collectors.toSet());
    }




}
