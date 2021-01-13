package org.mddarr.ui.request.service.security;

import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository.getUserEntityByEmail(email);

        if(optionalUserEntity.isPresent()){
            return new ApplicationUserDetails(optionalUserEntity.get());
        }else{
            throw new UsernameNotFoundException(email);
        }
    }
}
