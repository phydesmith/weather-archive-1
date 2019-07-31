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


select zipcode, geodata.latitude, geodata.longitude, station_id, stations.latitude, stations.longitude, sqrt((geodata.latitude-stations.latitude )*( geodata.latitude-stations.latitude)+( geodata.longitude-stations.longitude )*( geodata.longitude-stations.longitude )) distance
FROM GEODATA JOIN STATIONS
on 
    (geodata.latitude > (stations.latitude-1) and geodata.latitude < (stations.latitude+1))
    and
    (geodata.longitude > (stations.longitude-1) and geodata.longitude < (stations.longitude+1))
where zipcode = 10001 
order by distance asc fetch first row only;


##fetch first row only


##WHERE geodata.zipcode = 53027 min(sqrt( (( geodata.latitude-stations.latitude )( geodata.latitude-stations.latitude))+(( geodata.longitude-stations.longitude )( geodata.longitude-stations.longitude )) ));
select * from geodata join stations
on 
WHERE geodata.zipcode = 53033 and  ;


## -45.20362
## -45.006318
## -44.71004




##/c/Users/peter.hydesmith/Documents/projects/weather-projects/weather/src/main/resources/io/javasmithy/data/formatted/stations/stations.del