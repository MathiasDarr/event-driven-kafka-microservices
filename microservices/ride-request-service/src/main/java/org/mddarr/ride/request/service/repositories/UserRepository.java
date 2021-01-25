package org.mddarr.ride.request.service.repositories;


import org.mddarr.ride.request.service.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


    @Query(value = "SELECT * FROM users.users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmailIgnoreCase(String email);

}
