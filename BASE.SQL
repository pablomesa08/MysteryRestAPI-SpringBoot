-- ESTAS EJECUCIONES NO DEBEN CORRERSE, LA API DEBE CREAR LAS TABLAS Y LOS DATOS
-- TOMAR COMO GUIA PARA CREAR LOS METODOS DE LA API

CREATE TABLE victimas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    fecha_nacimiento DATE,
    fecha_defuncion DATE,
    causa_muerte VARCHAR(255),
    familia_id INT
);

CREATE TABLE familias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE casos (
    id SERIAL PRIMARY KEY,
    descripcion TEXT
);

CREATE TABLE victimas_familias (
    victima_id INT,
    familia_id INT
);

CREATE TABLE victimas_casos (
    victima_id INT,
    caso_id INT
);

INSERT INTO familias (nombre) VALUES
    ('Porras'),
    ('Bonet'),
    ('Mesa'),
    ('Hincapie');

INSERT INTO victimas (nombre, apellido, fecha_nacimiento, fecha_defuncion, causa_muerte, familia_id) VALUES
    ('Lorenzo', 'Porras', '1970-05-15', '2023-01-10', 'Asesinato', 1),
    ('Andrea', 'Mesa', '1985-08-22', '2023-02-20', 'Asesinato', 3),
    ('Isis', 'Bonet', '1975-01-01', '2023-03-30', 'Asesinato', 2),
    ('Luis', 'Perez', '1980-12-12', '2003-04-30', 'Hipertension', 4);

INSERT INTO casos (descripcion) VALUES
    ('Cuerpo colgado del techo con cuerdas doradas'),
    ('Cuerpo en bañera llena de monedas de oro'),
    ('Cuerpo torturado luego de entrenar una IA en Eclipse'),
    ('Cuerpo encontrado en un McDonalds luego de comerse una Big Mac');

INSERT INTO victimas_familias (victima_id, familia_id) VALUES
    (1, 1),
    (2, 3),
    (3, 2),
    (4, 4);

INSERT INTO victimas_casos (victima_id, caso_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);