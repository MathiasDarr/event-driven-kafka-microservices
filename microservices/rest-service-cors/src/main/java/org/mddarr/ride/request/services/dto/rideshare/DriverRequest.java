package org.mddarr.ride.request.services.dto.rideshare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverRequest {
    private String driverid;
    private String first_name;
    private String last_name;
    private String city;
    private int seats;

}
