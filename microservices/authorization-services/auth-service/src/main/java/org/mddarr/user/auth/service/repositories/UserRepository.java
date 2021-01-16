package org.mddarr.user.auth.service.repositories;


import org.mddarr.user.auth.service.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


    @Query(value = "SELECT * FROM users.users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmailIgnoreCase(String email);

}
