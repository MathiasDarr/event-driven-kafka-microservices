package org.mddarr.rides.request.service.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverRequest {
    private String driverid;
    private String first_name;
    private String last_name;
    private String city;
    private int seats;

}
