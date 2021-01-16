package org.mddarr.ui.request.service.security;

import org.mddarr.ui.request.service.models.UserEntity;
import org.mddarr.ui.request.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ApplicationUserDetails implements UserDetailsService {

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return new User("foo", "foo",
//                new ArrayList<>());
//    }
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<UserEntity> optionalUser = userRepository.findByEmailIgnoreCase(email); //<3>

        if (optionalUser.isPresent()) {
            UserEntity foundUser = optionalUser.get();
            return new User(foundUser.getEmail(), foundUser.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException(String.format("User with email %s could not be found", email));
        }
    }


}