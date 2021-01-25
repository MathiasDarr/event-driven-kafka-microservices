package org.mddarr.ride.request.service.repositories;

import org.mddarr.ride.request.service.models.DriverEntity;
import org.mddarr.ride.request.service.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, String> {

    @Query(value = "SELECT * FROM users.drivers WHERE email = :email", nativeQuery = true)
    Optional<DriverEntity> findByEmailIgnoreCase(String email);

}