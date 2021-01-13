package org.mddarr.ui.request.service.repositories;


import org.mddarr.ui.request.service.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "SELECT * FROM providers WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> getUserEntityByEmail(String email);


}
