-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name FROM country;

-- Selecting the name and population of all countries
SELECT name, population FROM country;

-- Selecting all columns from the city table
SELECT * FROM city;

-- OR Select All columns by listing them
SELECT id, name, countrycode, district, population FROM city;

-- Select districts from the city table
SELECT DISTINCT district FROM city;

-- Can rename columns using AS (Alias)
SELECT name AS city_name FROM city;

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * FROM city WHERE district = 'Ohio';

-- Selecting countries that gained independence in the year 1776
SELECT * FROM country WHERE indepyear = 1776;

-- Selecting countries not in Asia
SELECT * FROM country WHERE continent != 'Asia';
-- OR using <>
SELECT * FROM country WHERE continent <> 'Asia';

-- Selecting countries that do not have an independence year
SELECT * FROM country WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year
SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million
SELECT * FROM country WHERE population > 5000000;


-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT * FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America
SELECT * FROM country WHERE continent = 'North America' OR continent = 'South America';

-- Selecting using IN()
SELECT * FROM country WHERE continent IN ('North America', 'South America');

-- Selecting using NOT IN()
SELECT * FROM country WHERE continent NOT IN ('North America', 'South America');

-- Between allows you to select where a columns value is BETWEEN value1 AND value2
SELECT * FROM country WHERE surfacearea BETWEEN 50000 AND 150000;

-- LIKE allows select of columns with data based on a wildcard (placeholder)

-- Select All countries that begin with the letter A
SELECT name FROM country WHERE name LIKE 'A%';

-- Select ALL countries that end with the letter a
SELECT name FROM country WHERE name LIKE '%a';

-- Select ALL countries that contain an a
SELECT name FROM country WHERE name LIKE '%a%';

-- LIKE is case sensitive, but ILIKE is not (ILIKE is postgres only)
SELECT name FROM country WHERE name ILIKE '%a%';

-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
SELECT name, population, lifeexpectancy, (population / surfacearea) AS density FROM country;


