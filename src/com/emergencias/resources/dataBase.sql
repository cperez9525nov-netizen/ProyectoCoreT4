CREATE DATABASE Emergencias;
      USE Emergencias;


CREATE TABLE Personas (
                          dni       VARCHAR(12),
                          nombre    VARCHAR(25) NOT NULL,
                          apellido  VARCHAR(15),
                          telefono  VARCHAR(12)  NOT NULL,
                          patologia VARCHAR(20),
                          edad      INT         NOT NULL,
                          alergias VARCHAR(30),
                          CONSTRAINT per_dni_pk PRIMARY KEY (dni)
);


CREATE TABLE ContactoConfianza (
                                   id VARCHAR(10),
                                   nombre VARCHAR(25) NOT NULL,
                                   telefono VARCHAR(12) NOT NULL,
                                   dni_familiar VARCHAR(12),
                                   CONSTRAINT con_id_pk PRIMARY KEY (id),
                                   CONSTRAINT con_dni_fk FOREIGN KEY (dni_familiar) REFERENCES Personas(dni)
);


/* Insertamos los datos de la tabla Personas-- */


INSERT INTO Personas VALUES
                         ('74221034W', 'Cristian', 'Pérez', '668201882', 'Ninguna', 31, 'No'),
                         ('24551892L', 'Angie', 'Marín', '679998191','Ninguna', 25, 'No'),
                         ('44910200T', 'Lucia', 'Marín', '699012111', 'Diabetes2', 43, 'No'),
                         ('31111892G', 'Francisco', 'Pérez', '610010082', 'Asma', 63, 'Penicilina'),
                         ('211965787F', 'María', 'Beltrá', '617772881', 'Hipertiroidismo', 61, 'Antiinflamatorios'),
                         ('51181812G', 'Rubén', 'Pérez', '654656819', 'Ninguna', 38, 'No'),
                         ('689918211L', 'Luci', 'Horga', '691191831', 'Ninguna', 45, 'No'),
                         ('819928932R', 'Ana Belén', 'Marín', '681104343', 'Ninguna', 10, 'Penicilina'),
                         ('189822891Q', 'Aurica', 'Horga', '789191236', 'Ninguna', 71, 'Aditivos alimenticios');


 /* Insertamos los datos de la tabla ContactoConfianza */


INSERT INTO ContactoConfianza VALUES
                                  ('88192092T', 'Pascual', '686669110', '74221034W'),
                                  ('19823319J', 'Angeline', '661120080', '24551892L'),
                                  ('66101898G', 'Patricio', '711108298', '51181812G'),
                                  ('61899898C', 'Kevin', '779981019', '31111892G');


SELECT * FROM Personas;
SELECT * FROM ContactoConfianza;