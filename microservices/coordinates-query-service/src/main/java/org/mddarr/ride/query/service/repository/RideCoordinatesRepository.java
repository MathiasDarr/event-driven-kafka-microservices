package org.mddarr.ride.query.service.repository;

import org.mddarr.ride.query.service.models.RideCoordinate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RideCoordinatesRepository extends CassandraRepository<RideCoordinate, String> {
    @Query("SELECT * FROM coordinates WHERE rideid=?0")
    List<RideCoordinate> getRideCoordinates(String rideid);

}