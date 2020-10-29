SET MODE Postgresql;

CREATE DATABASE wildlife;

\c wildlife

CREATE  TABLE IF NOT EXISTS animals (
id SERIAL PRIMARY KEY,
animalName VARCHAR,
type VARCHAR,
health VARCHAR,
age INTEGER
);

CREATE  TABLE IF NOT EXISTS sightings (
id SERIAL PRIMARY KEY,
location VARCHAR,
rangerName VARCHAR,
wildlifeId INTEGER
);


