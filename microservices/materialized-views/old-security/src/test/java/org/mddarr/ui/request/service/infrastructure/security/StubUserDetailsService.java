package org.mddarr.ui.request.service.infrastructure.security;


import org.mddarr.ui.request.service.security.ApplicationUserDetails;
import org.mddarr.ui.request.service.users.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class StubUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch (username) {
            case Users.DRIVER_EMAIL:
                return new ApplicationUserDetails(Users.driver());
            case Users.RIDER_EMAIL:
                return new ApplicationUserDetails(Users.rider());
            default:
                throw new UsernameNotFoundException(username);
        }
    }
}
