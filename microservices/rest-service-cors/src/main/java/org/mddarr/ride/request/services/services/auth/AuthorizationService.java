package org.mddarr.ride.request.services.services.auth;

import lombok.AllArgsConstructor;

import org.mddarr.ride.request.services.dto.auth.AuthenticationResponse;
import org.mddarr.ride.request.services.dto.auth.LoginRequest;
import org.mddarr.ride.request.services.dto.auth.RefreshTokenRequest;
import org.mddarr.ride.request.services.dto.auth.RegisterRequest;
import org.mddarr.ride.request.services.models.UserEntity;
import org.mddarr.ride.request.services.repositories.UserRepository;
import org.mddarr.ride.request.services.security.JwtProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AuthorizationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Transactional
    public void register(RegisterRequest registerRequest){
        UserEntity user = new UserEntity();
        user.setUserid(UUID.randomUUID().toString());
        user.setEmail(registerRequest.getEmail());
        user.setFirst_name(registerRequest.getFirstname());
        user.setLast_name(registerRequest.getLastname());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setUpdate_ts(new Date(System.currentTimeMillis()));
        userRepository.save(user);
    }



    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        System.out.println("LOGGING IN");
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .email(loginRequest.getEmail())
                .build();
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .email(refreshTokenRequest.getUsername())
                .build();
    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

}
