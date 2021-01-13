package org.mddarr.ui.request.service.infrastructure.security;


import org.junit.Test;
import org.mddarr.ui.request.service.repositories.UserRepository;
import org.mddarr.ui.request.service.security.ApplicationUserDetails;
import org.mddarr.ui.request.service.security.ApplicationUserDetailsService;
import org.mddarr.ui.request.service.users.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplicationUserDetailsServiceTest {

    @Test
    public void givenExistingUsername_whenLoadingUser_userIsReturned() {
        UserRepository repository = mock(UserRepository.class);
        ApplicationUserDetailsService service = new ApplicationUserDetailsService(repository); // <1>
        when(repository.getUserEntityByEmail(Users.DRIVER_EMAIL)) // <2>
                                                                    .thenReturn(Optional.of(Users.driver()));

        UserDetails userDetails = service.loadUserByUsername(Users.DRIVER_EMAIL); //<3>
        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo(Users.DRIVER_EMAIL); //<4>
//        assertThat(userDetails.getAuthorities()).extracting(GrantedAuthority::getAuthority)
//                                                .contains("ROLE_OFFICER"); //<5>
//        assertThat(userDetails).isInstanceOfSatisfying(ApplicationUserDetails.class, //<6>
//                                                       applicationUserDetails -> {
//                                                           assertThat(applicationUserDetails.ge())
//                                                                   .isEqualTo(Users.officer().getId());
//                                                       });
    }

    @Test//(expected = UsernameNotFoundException.class) //<7>
    public void givenNotExistingUsername_whenLoadingUser_exceptionThrown() {
        UserRepository repository = mock(UserRepository.class);
        ApplicationUserDetailsService service = new ApplicationUserDetailsService(repository);
        when(repository.getUserEntityByEmail(anyString())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.loadUserByUsername("i@donotexist.com"))
                .isInstanceOf(UsernameNotFoundException.class);

        //service.loadUserByUsername("i@donotexist.com");

    }
}