# Wildlife App
# Author
**Onesmus Okali**

## Description
The app is meant for ranger to use to track animals and endangered animals, where they have been sighted and for the various areas and by the respective rangers.

## Application set-up

-You have PostgreSql and JDK 8+ installed
- You have a idea (preferred Intellij)
-You have a idea (preferred Intellij)
-Clone the repo git clone https://github.com/Ashisoma/Wildlife
-Open the folder from github in your Intellij Idea 
-On your terminal type psql to open postgresql command shell
-Create database CREATE DATABASE database_name
-Connect to the DB \c database_name
-Create table CREATE TABLE table_name(name varchar)

## In PSQL:
 - CREATE DATABASE wildlife_tracker;
 - CREATE TABLE animals (id serial PRIMARY KEY, animalName varchar ,type varchar ,age varchar, health varchar);
 - CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, rangerName varchar, wildlifeId int );
## Techologies Used
- Java
- Spark
- Handlebars templates
- Bootstrap
- Heroku CLI
- Intellij Idea

### Figma link
https://www.figma.com/proto/ksuyplSSAZkunxCocmXXPt/Heronesmus?node-id=1%3A3&scaling=min-zoom

## Contribution
You can fork the repo and add your extra feature to the web app. Click on the following link to fork: https://github.com/Ashisoma/Wlildlife

## Known bugs
If there seem to be any other bugs on the web app, do reach via ashisomaokali@gmail.com

## Licence and copyright
The app is under the : MIT Licence Onesmus Okali 2020
