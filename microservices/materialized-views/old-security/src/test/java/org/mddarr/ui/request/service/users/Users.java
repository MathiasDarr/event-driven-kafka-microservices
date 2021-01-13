package org.mddarr.ui.request.service.users;

import org.mddarr.ui.request.service.models.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;
import java.util.UUID;

public class Users {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static final String DRIVER_FIRST_NAME ="Charles";
    public static final String DRIVER_LAST_NAME ="Daniels";

    public static final String DRIVER_EMAIL = "driverr@example.com";
    public static final String DRIVER_PASSWORD = "driver";


    public static final String RIDER_FIRST_NAME ="James";
    public static final String RIDER_LAST_NAME ="Ericson";
    public static final String RIDER_EMAIL = "rider@example.com";
    public static final String RIDER_PASSWORD = "rider";


    private static UserEntity DRIVER = UserEntity.createDriver(DRIVER_FIRST_NAME,DRIVER_LAST_NAME, DRIVER_EMAIL, PASSWORD_ENCODER.encode(DRIVER_PASSWORD));

    private static UserEntity RIDER = UserEntity.createDriver(RIDER_FIRST_NAME,RIDER_LAST_NAME, RIDER_EMAIL, PASSWORD_ENCODER.encode(RIDER_PASSWORD));



    public static UserEntity driver() {
        return DRIVER;
    }

    public static UserEntity rider() {
        return RIDER;
    }

    private Users() {
    }


}
