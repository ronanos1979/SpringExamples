# Spring Examples

This is a test repository just with some spring examples that were initially written with just spring not spring boot.

## Databases
There is no dynamic data source. It is just hard coded to MySQL or Postgres in Spring-Module.xml

```
    <!-- <import resource="database/Spring-Datasource-MySQL.xml" /> -->
    <import resource="database/Spring-Datasource-Postgresql.xml" />
```

### PostGres

The SQL is

Can be done in the UI of pgAdmin or

Add the following folder to the Path env variable

```
C:\Program Files\PostgreSQL\18\bin
```

Then run

``` 
psql -U postgres -h localhost
```

Then use this

```
CREATE DATABASE springexamples;
CREATE USER "springexamples-user" WITH PASSWORD 'dummyspringexamples';
GRANT ALL PRIVILEGES ON DATABASE springexamples TO "springexamples-user";
\c springexamples
-- allow the user to use the schema
GRANT USAGE ON SCHEMA public TO "springexamples-user";
-- allow the user to create tables in the schema
GRANT CREATE ON SCHEMA public TO "springexamples-user";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO "springexamples-user";
GRANT ALL PRIVILEGES ON TABLE customer TO "springexamples-user";
GRANT USAGE, SELECT ON SEQUENCE customer_cust_id_seq TO "springexamples-user";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON TABLES TO "springexamples-user";
```