INSERT INTO ninja (id, nombre, rango, aldea) VALUES
(1, 'naruto', 'A', 'konoha'),
(2, 'sasuke', 'B', 'konoha'),
(3, 'sakura', 'C', 'konoha'),
(4, 'konohamaru', 'B', 'konoha');

INSERT INTO mision (id, descripcion, rango) VALUES
(1, 'buscar la ubicación de akatsuki', 'A'),
(2, 'escolta a un mercader', 'B'),
(3, 'rescata a gaara', 'A'),
(4, 'llevar un mensaje a la aldea de la niebla', 'B'),
(5, 'captura a pain', 'A'),
(6, 'ayuda a los ancianos con su mercado', 'C'),
(7, 'encuentra un perro perdido', 'C');

INSERT INTO misionNinja (idNinja, idMision, fechaInicio, fechaFin) VALUES
(1, 1, '2023-10-21 00:00:00', '2023-11-22 00:00:00'),
(2, 2, '2023-09-11 00:00:00', '2023-10-10 00:00:00'),
(3, 3, '2023-08-01 00:00:00', null),
(4, 4, '2023-12-01 00:00:00', null);


INSERT INTO habilidad (idNinja, nombre, descripcion) VALUES
(1, 'rasengan', 'esfera de chakra en espiral'),
(2, 'chidori', 'destello eléctrico de chakra'),
(3, 'ninjutsu médico', 'curación de heridas');
