
CREATE DATABASE wildlife_tracks;

\c wildlife wildlife_tracks;

CREATE  TABLE IF NOT EXISTS animals (
id SERIAL PRIMARY KEY,
animalName VARCHAR,
type VARCHAR,
health VARCHAR,
age INTEGER,
location VARCHAR,
rangerName VARCHAR
);




