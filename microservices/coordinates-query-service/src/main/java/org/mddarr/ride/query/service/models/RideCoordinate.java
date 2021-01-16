package org.mddarr.ride.query.service.models;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;



@Table("trip_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RideCoordinate {

    @PrimaryKeyColumn(name="rideid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String rideid;

    @PrimaryKeyColumn(name="time", ordinal = 1, type = PrimaryKeyType.CLUSTERED )
    private  Date time;

    private Double latitude;
    private Double longitude;


}


