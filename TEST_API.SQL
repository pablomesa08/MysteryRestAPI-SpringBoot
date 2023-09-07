INSERT INTO familias (id, nombre)
VALUES (1, 'Porras'),
       (2, 'Bonet'),
       (3, 'Mesa'),
       (4, 'Hincapie');

INSERT INTO victimas (id, nombre, apellido, fecha_nacimiento, fecha_defuncion, causa_muerte, familia_id)
VALUES (1, 'Lorenzo', 'Porras', '1970-05-15', '2023-01-10', 'Asesinato', 1),
       (2, 'Andrea', 'Mesa', '1985-08-22', '2023-02-20', 'Asesinato', 3),
       (3, 'Isis', 'Bonet', '1975-01-01', '2023-03-30', 'Asesinato', 2),
       (4, 'Luis', 'Perez', '1980-12-12', '2003-04-30', 'Hipertension', 4);

INSERT INTO casos (id, descripcion)
VALUES (1, 'Cuerpo colgado del techo con cuerdas doradas'),
       (2, 'Cuerpo en bañera llena de monedas de oro'),
       (3, 'Cuerpo torturado luego de entrenar una IA en Eclipse'),
       (4, 'Cuerpo encontrado en un McDonalds luego de comerse una Big Mac');

INSERT INTO victimas_familias (victima_id, familias_id)
VALUES (1, 1),
       (2, 3),
       (3, 2),
       (4, 4);

INSERT INTO victimas_casos (victima_id, casos_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);