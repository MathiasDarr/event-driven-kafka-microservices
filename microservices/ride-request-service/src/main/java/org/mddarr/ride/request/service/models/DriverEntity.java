package org.mddarr.ride.request.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import lombok.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="drivers",schema = "users")
public class DriverEntity {

    @Id
    private String driverid;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date update_ts;

}


