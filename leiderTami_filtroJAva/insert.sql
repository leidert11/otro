INSERT INTO ninja (id, nombre, rango, aldea) VALUES
(1, 'naruto', 'A','konoha'),
(2, 'sasuke', 'B', 'konoha'),
(3, 'sakura', 'C', 'konoha');

INSERT INTO mision (id,descripcion, rango, fechainicio, fechaFin) VALUES
(1,'buscar la ubicacion de akatsuki', 'A', '2023-10-21', '2023-11-22'),
(2,'escolta a un mercader', 'B', '2023-09-11', '2023-10-10'),
(3,'rescata a gaara', 'A', '2023-09-11', '2023-10-10'),
(4,'llevar un mensaje a la aldea de la niebla', 'B', '2023-09-11', '2023-10-10'),
(5,'captura a pain', 'A', '2023-09-11', '2023-10-10'),
(6,'ayuda a los ancianos con su mercado', 'C', '2023-09-11', '2023-10-10'),
(7,'encuentra un perro perdido', 'C', '2023-08-01', '2023-08-10');

INSERT INTO misionNinja (idNinja, idMision, fechaInicio, fechaFin) VALUES
(1, 1, '2023-10-21', '2023-11-22'),
(2, 2, '2023-09-11', '2023-10-10'),
(3, 3, '2023-08-01', '2023-08-10');

INSERT INTO habilidad (idNinja, nombre, descripcion) VALUES
(1, 'rasengan', 'esfera de chakra en espiral'),
(2, 'chidori', 'destello electrico de chakra'),
(3, 'ninjutsu medico', 'curacion de heridas');