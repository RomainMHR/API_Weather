DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
                         id INTEGER AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(255),
                         prenom VARCHAR(255),
                         mail VARCHAR(255),
                         password VARCHAR(255)
);