package org.mddarr.rides.request.service.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RideRequest {
    private String userid;
    private Integer riders;
    private String destination;
    private String city;
}
