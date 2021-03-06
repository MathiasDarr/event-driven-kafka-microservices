package org.mddarr.rides.request.service.mock;

import org.mddarr.rides.event.dto.AvroDriver;
import org.mddarr.rides.request.service.Constants;

import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.Schema;
import org.mddarr.rides.event.dto.AvroRideRequest;


/**
 * This code is not thread safe and should not be used in production environment
 */
public class CustomKafkaAvroDeserializer extends KafkaAvroDeserializer {
    @Override
    public Object deserialize(String topic, byte[] bytes) {
        if (topic.equals(Constants.RIDE_REQUEST_TOPIC)) {
            this.schemaRegistry = getMockClient(AvroRideRequest.SCHEMA$);
        }

        if (topic.equals(Constants.DRIVERS_TOPIC)) {
            this.schemaRegistry = getMockClient(AvroDriver.SCHEMA$);
        }

        return super.deserialize(topic, bytes);
    }

    private static SchemaRegistryClient getMockClient(final Schema schema$) {
        return new MockSchemaRegistryClient() {
            @Override
            public synchronized Schema getById(int id) {
                return schema$;
            }
        };
    }
}
