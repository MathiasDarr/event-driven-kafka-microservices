package org.mddarr.ride.query.service.base;

import com.datastax.driver.core.Session;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mddarr.ride.query.service.repository.RideCoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public abstract class RideQueryRepositoryAbstractBaseTest {
    private Session session;

    @Autowired
    protected RideCoordinatesRepository rideCoordinatesRepository;

    public abstract Session getSession();


}
