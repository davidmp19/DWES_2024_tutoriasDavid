insert into curso (nombre) values ('1A');
insert into curso (nombre) values ('1B');
insert into curso (nombre) values ('2A');
insert into curso (nombre) values ('2B');
insert into curso (nombre) values ('3A');
insert into curso (nombre) values ('3B');
insert into plan (nombre) values ('P2023-2024-1A');
insert into plan (nombre) values ('P2023-2024-1B');
insert into plan (nombre) values ('P2023-2024-2A');
insert into plan (nombre) values ('P2023-2024-2B');
insert into plan (nombre,FK_CURSO) values ('P2023-2024-3A','1A');
insert into plan (nombre,FK_CURSO) values ('P2023-2024-3B','1B');
insert into tutor (nombre,email) values ('Marcos','marcos@educastur.org');
insert into tutor (nombre,email) values ('Javier','javier@educastur.org');
insert into tutor (nombre,email,plan) values ('Maria','maria@educastur.org',3);
insert into tutor (nombre,email,plan) values ('Marta','marta@educastur.org',4);
insert into tutor (nombre,email,plan) values ('Pedro','pedro@educastur.org',5);
insert into tutor (nombre,email,plan) values ('Lucia','lucia@educastur.org',6);

insert into Actividad(obligatoria,nombre,descripcion) values (true,'Deporte','descripcion');
insert into Actividad(obligatoria,nombre,descripcion) values (false,'Deporte2','descripcion2');
insert into Actividad(obligatoria,nombre,descripcion) values (true,'Deporte3','descripcion3');
insert into Actividad(obligatoria,nombre,descripcion) values (false,'Deporte4','descripcion4');

insert into enmarca(idActividad,idPlan,fecha)values(1,1,'01-01-2024');
insert into enmarca(idActividad,idPlan,fecha)values(2,2,'02-02-2024');
insert into enmarca(idActividad,idPlan,fecha)values(3,3,'03-03-2024');
insert into enmarca(idActividad,idPlan,fecha)values(4,4,'04-04-2024');




