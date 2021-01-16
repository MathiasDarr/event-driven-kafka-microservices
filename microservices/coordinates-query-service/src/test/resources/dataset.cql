CREATE KEYSPACE IF NOT EXISTS ks1 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

DROP TABLE IF EXISTS ks1.logs;

CREATE TABLE IF NOT EXISTS ks1.logs (
    id text,
    query text,
    PRIMARY KEY (id)
);

INSERT into ks1.logs(id, query) values ('1','cinema');
