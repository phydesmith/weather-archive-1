CREATE TABLE stations (
    id VARCHAR(6) NOT NULL PRIMARY KEY,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);


CREATE TABLE locations (
    zipcode INT NOT NULL PRIMARY KEY,
    city VARCHAR(50),
    state VARCHAR(4),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

LOAD XML INFILE 'us-geodata.xml'
INTO TABLE locations
ROWS IDENTIFIED BY '<location>';