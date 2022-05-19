DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  PASSWORD VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  ROLE VARCHAR(250) NOT NULL,
  BLOKING INT
);

DROP TABLE IF EXISTS hotels;

CREATE TABLE hotels (
  id INT PRIMARY KEY,
  NAMEH VARCHAR(250) NOT NULL,
  TYPE VARCHAR(250) NOT NULL,
  ADRESS VARCHAR(250) NOT NULL
);

INSERT INTO users (ID, FIRST_NAME, PASSWORD, EMAIL,ROLE,BLOKING) VALUES
  (1, 'first0', 'last 1', 'abc1@gmail.com','user',0),
  (2, 'first1', 'last 2', 'abc2@gmail.com','user',0),
  (3, 'first2', 'last 3', 'abc3@gmail.com','user',0);

INSERT INTO hotels (ID, NAMEH, TYPE, ADRESS) VALUES
  (1, 'Седьмое небо', 'hotel', 'St. Kutaykova, d 5'),
  (2, 'first', 'last 2', 'abc2@gmail.com'),
  (3, 'first', 'last 3', 'abc3@gmail.com');
