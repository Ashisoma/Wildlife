SET MODE PostgreSQL;

CREATE DATABASE wildlife;

\c wildlife

CREATE  TABLE IF NOT EXISTS rangers (
id SERIAL PRIMARY KEY,
rangerName VARCHAR,
badge INTEGER,
contact VARCHAR
);

CREATE  TABLE IF NOT EXISTS animals (
id SERIAL PRIMARY KEY,
animalName VARCHAR,
rangerId INTEGER,
locationId INTEGER
);


CREATE  TABLE IF NOT EXISTS endangeredAnimals (
id SERIAL PRIMARY KEY,
dangerName VARCHAR,
health VARCHAR,
age INTEGER,
rangerId INTEGER,
locationId INTEGER
);


CREATE  TABLE IF NOT EXISTS location (
id SERIAL PRIMARY KEY,
location VARCHAR,
);