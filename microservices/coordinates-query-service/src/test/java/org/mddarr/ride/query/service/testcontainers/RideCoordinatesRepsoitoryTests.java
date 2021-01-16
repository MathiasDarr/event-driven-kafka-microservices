package org.mddarr.ride.query.service.testcontainers;

import com.datastax.driver.core.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mddarr.ride.query.service.base.RideQueryRepositoryAbstractBaseTest;
import org.mddarr.ride.query.service.config.CassandraConfig;
import org.testcontainers.containers.GenericContainer;

import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

public class RideCoordinatesRepsoitoryTests extends RideQueryRepositoryAbstractBaseTest {

    @RegisterExtension
    public static GenericContainer cassandra = new GenericContainer("cassandra:3").withExposedPorts(9042);

    @Override
    public Session getSession() {
        Session session = CassandraConfig.createSession(cassandra.getContainerIpAddress(), cassandra.getMappedPort(9042));
        session.execute("CREATE KEYSPACE  ks1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }");
        return session;
    }

    @Test
    public void testCassandraRepository(){

    }


}
