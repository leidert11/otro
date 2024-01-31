drop database if exists ninja;

create database if not exists ninja;
use ninja;

CREATE TABLE ninja (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    rango ENUM('A', 'B', 'C'),
    aldea VARCHAR(255)
);

CREATE TABLE mision (
    id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    rango ENUM('A', 'B', 'C'),
    PRIMARY KEY (id)
);

CREATE TABLE misionNinja (
    idNinja INT NOT NULL,
    idMision INT NOT NULL,
    fechaInicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fechaFin DATETIME,
    FOREIGN KEY (idNinja) REFERENCES ninja(id),
    FOREIGN KEY (idMision) REFERENCES mision(id) ON DELETE CASCADE
);

CREATE TABLE habilidad (
    idNinja INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    PRIMARY KEY (idNinja)
);


ALTER TABLE misionNinja ADD CONSTRAINT misionNinja_fk0 FOREIGN KEY (idNinja) REFERENCES ninja(id);

ALTER TABLE misionNinja ADD CONSTRAINT misionNinja_fk1 FOREIGN KEY (idMision) REFERENCES mision(id);

ALTER TABLE habilidad ADD CONSTRAINT habilidad_fk0 FOREIGN KEY (idNinja) REFERENCES ninja(id);