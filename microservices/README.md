### Microservices ###
This directory contains microservices developed using Spring Boot & Kafka 


## Authoirzation Serivices ##
This module contains a microservice whose responsability is to issue JWT tokens to authenticated users

# Rides Service Module
* ride-request-service
    * Client facing spring boot microservice which listens to riders & drivers making ride requests.  Writes requests to 'ride requests' & 'drivers'  topics, entering them into the ride matching pool.  

* dispatch-service
    * microservice consumes from the 'ride requests' & 'topics', performing stateful stream processing, & assigning a driver w/ a rider who has a requested a rider. 

