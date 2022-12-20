create database if not exists empresainformatica;
use empresainformatica;

grant all privileges on empresainformatica.* to masemoel@localhost;

create table if not exists direccion(
	codigo tinyint,
	nombrevia varchar(20),
    numero int,
    piso varchar(2),
    cp int,
    localidad varchar(20),
    constraint pk_direccion primary key(codigo)
);

create table if not exists oficinas(
	codigo tinyint,
    nombre varchar(15),
    cod_direccion tinyint,
    constraint pk_oficinas primary key(codigo),
    constraint fk_direcciones_en_oficinas foreign key(cod_direccion) references direccion(codigo)
);

create table if not exists empleados (
	dni varchar(9),
    nombre varchar(20),
    apellido1 varchar(15),
    apellido2 varchar(15),
    sueldo int,
    fecha_nacimiento date,
    cod_oficina tinyint,
    constraint pk_empleados primary key (dni),
    constraint fk_oficinas_en_empleados foreign key (cod_oficina) references oficinas(codigo)
);

create table if not exists administrativos(
	experiencia varchar(7),
    dni varchar(9),
    constraint pk_administrativos primary key(dni),
    constraint fk_empleados_en_administrativos foreign key (dni) references empleados(dni)
);

create table if not exists vendedores (
	zona int,
    dni varchar(9),
    constraint pk_vendedores primary key(dni),
    constraint fk_empleados_en_vendedores foreign key (dni) references empleados(dni)
);

create table if not exists analistas (
	titulacion varchar(30),
    dni varchar(9),
    constraint pk_analistas primary key(dni),
    constraint fk_empleados_en_analistas foreign key (dni) references empleados(dni)
);

create table if not exists programadores (
	experiencia varchar(7),
    tecnologias varchar(50),
    dni varchar(9),
    constraint pk_programadores primary key(dni),
    constraint fk_empleados_en_programadores foreign key (dni) references empleados(dni)
);

insert into direccion values
(1, 'Avenida de Arjona', 58, '2A', 23006, 'Jaén'),
(2, 'Calle Roldán y Marín', 14, '1B', 23007, 'Linares'),
(3, 'Avenida de Madrid', 79, '4C', 23005, 'Jaén');

insert into oficinas values
(001, 'RRHH', 1),
(002, 'Desarrollo', 3),
(003, 'Soporte cliente', 2);

insert into empleados values
('77691163S', 'Manuel José', 'Moral', 'Eliche', 0, '2003-04-12', 2),
('11111111F', 'Pepe', 'González', 'Oramas', 0, '1988-12-06', 1),
('87654329Z', 'Ana', 'Gringa', 'Shakespeare', 0, '1996-05-29', 3),
('25987456J', 'Andrés', 'De Vandelvira', 'Sinarte', 0, '2001-07-24', 3);

insert into administrativos values
('Alta', '11111111F');

insert into programadores values
('Baja', 'Java - HTML - CSS - Android - SQL - Git', '77691163S');

insert into analistas values
('Máster en ADE', '87654329Z');

insert into vendedores values
(1, '25987456J');