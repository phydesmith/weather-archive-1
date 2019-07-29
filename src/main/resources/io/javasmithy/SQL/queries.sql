CONNECT 'jdbc:derby:locales;create=true';

CREATE TABLE STATIONS (
    station_id VARCHAR(6),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE(
    null,
    'STATIONS',
    'c:\\Users\\peter.hydesmith\\Documents\\projects\\weather-projects\\weather\\src\\main\\resources\\io\\javasmithy\\data\\formatted\\stations\\stations.csv',
    ',',
    null,
    null,
    0
);

alter table stations add column station_number INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1;


CREATE TABLE geodata (
    zipcode INTEGER NOT NULL PRIMARY KEY,
    city VARCHAR(40),
    state CHAR(2),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE(
    null,
    'GEODATA',
    'c:\\Users\\peter.hydesmith\\Documents\\projects\\weather-projects\\weather\\src\\main\\resources\\io\\javasmithy\\data\\formatted\\geodata\\zipdata.csv',
    ',',
    null,
    null,
    0
);


select *
FROM GEODATA JOIN STATIONS
on 
    (geodata.latitude > (stations.latitude-.2) and geodata.latitude < (stations.latitude+.2))
    and
    (geodata.longitude > (stations.longitude-.2) and geodata.longitude < (stations.longitude+.2))
WHERE geodata.zipcode = 53033 ;

##/c/Users/peter.hydesmith/Documents/projects/weather-projects/weather/src/main/resources/io/javasmithy/data/formatted/stations/stations.del