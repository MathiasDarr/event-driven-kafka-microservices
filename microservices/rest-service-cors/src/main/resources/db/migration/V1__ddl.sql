CREATE SCHEMA IF NOT EXISTS users;
CREATE TABLE IF NOT EXISTS users.users(
    userid VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    update_ts timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS users.drivers(
    driverid VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    update_ts timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS users.riders(
    riderid VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    update_ts timestamp NOT NULL
);


CREATE TABLE IF NOT EXISTS users.refresh_token(
    id VARCHAR(50) PRIMARY KEY,
    token VARCHAR,
    created_date timestamp
);

