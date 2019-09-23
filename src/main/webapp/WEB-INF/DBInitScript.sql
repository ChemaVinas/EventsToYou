-- Insert sample records

DELETE FROM Sesion_Apuntada;
DELETE FROM Sesion;
DELETE FROM Valoracion;
DELETE FROM Evento_Guardado;
--DELETE FROM Evento;
DELETE FROM Miembros_Seguidos;
--DELETE FROM Miembro;
--DELETE FROM Organizador;
--DELETE FROM Usuario;


--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_miembro1','clave_usuario1','2019-01-01 00:00:00','miembro 1');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_miembro2','clave_usuario2','2019-01-01 00:00:00','miembro 2');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_miembro3','clave_usuario3','2019-01-01 00:00:00','miembro 3');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_miembro4','clave_usuario4','2019-01-01 00:00:00','miembro 4');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_miembro5','clave_usuario5','2019-01-01 00:00:00','miembro 5');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_organizador1','clave_organizador1','2019-01-01 00:00:00','organizador 1');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_organizador2','clave_organizador2','2019-01-01 00:00:00','organizador 2');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_organizador3','clave_organizador3','2019-01-01 00:00:00','organizador 3');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_organizador4','clave_organizador4','2019-01-01 00:00:00','organizador 4');
--insert into Usuario (login,clave,fecha_alta,nombre) VALUES ('login_organizador5','clave_organizador5','2019-01-01 00:00:00','organizador 5');

--insert into Miembro (login,biografia,ubicacion) VALUES ('login_miembro1','Biografía de ejemplo de miembro.','Jaén');
--insert into Miembro (login,biografia,ubicacion) VALUES ('login_miembro2','Biografía de ejemplo de miembro.','Jaén');
--insert into Miembro (login,biografia,ubicacion) VALUES ('login_miembro3','Biografía de ejemplo de miembro.','Jaén');
--insert into Miembro (login,biografia,ubicacion) VALUES ('login_miembro4','Biografía de ejemplo de miembro.','Jaén');
--insert into Miembro (login,biografia,ubicacion) VALUES ('login_miembro5','Biografía de ejemplo de miembro.','Jaén');

--insert into Organizador (login,descripcion,web) VALUES ('login_organizador1','Descripción de ejemplo de organizador.','www.organizador.com');
--insert into Organizador (login,descripcion,web) VALUES ('login_organizador2','Descripción de ejemplo de organizador.','www.organizador.com');
--insert into Organizador (login,descripcion,web) VALUES ('login_organizador3','Descripción de ejemplo de organizador.','www.organizador.com');
--insert into Organizador (login,descripcion,web) VALUES ('login_organizador4','Descripción de ejemplo de organizador.','www.organizador.com');
--insert into Organizador (login,descripcion,web) VALUES ('login_organizador5','Descripción de ejemplo de organizador.','www.organizador.com');

--insert into Evento (id,categoria,descripcion,titulo,total_asistentes,valoracion_media,web_entradas,organizador) VALUES (1,0,'primera descr evento', 'primer evento',20,5.5,'www.web.com','login_organizador1');
--insert into Evento (id,categoria,descripcion,titulo,total_asistentes,valoracion_media,web_entradas,organizador) VALUES (2,3,'segunda descr evento', 'segundo evento',50,2.5,'www.web.com','login_organizador1');
--insert into Evento (id,categoria,descripcion,titulo,total_asistentes,valoracion_media,web_entradas,organizador) VALUES (3,8,'tercer descr evento', 'tercer evento',10,7.5,'www.web.com','login_organizador2');
--insert into Evento (id,categoria,descripcion,titulo,total_asistentes,valoracion_media,web_entradas,organizador) VALUES (4,3,'cuarto descr evento', 'cuarto evento',15,6.5,'www.web.com','login_organizador3');

--insert into Evento (descripcion,titulo,total_asistentes,valoracion_media,web_entradas) VALUES ('adicional descr evento', 'evento adicional',30,10,'www.web.com');

update Usuario set clave='clave_usuario1', fecha_alta='2019-01-01 00:00:00', nombre='miembro 1' where login='login_miembro1';
update Usuario set clave='clave_usuario2', fecha_alta='2019-01-01 00:00:00', nombre='miembro 2' where login='login_miembro2';
update Usuario set clave='clave_usuario3', fecha_alta='2019-01-01 00:00:00', nombre='miembro 3' where login='login_miembro3';
update Usuario set clave='clave_usuario4', fecha_alta='2019-01-01 00:00:00', nombre='miembro 4' where login='login_miembro4';
update Usuario set clave='clave_usuario5', fecha_alta='2019-01-01 00:00:00', nombre='miembro 5' where login='login_miembro5';
update Usuario set clave='clave_organizador1', fecha_alta='2019-01-01 00:00:00', nombre='organizador 1' where login='login_organizador1';
update Usuario set clave='clave_organizador2', fecha_alta='2019-01-01 00:00:00', nombre='organizador 2' where login='login_organizador2';
update Usuario set clave='clave_organizador3', fecha_alta='2019-01-01 00:00:00', nombre='organizador 3' where login='login_organizador3';
update Usuario set clave='clave_organizador4', fecha_alta='2019-01-01 00:00:00', nombre='organizador 4' where login='login_organizador4';
update Usuario set clave='clave_organizador5', fecha_alta='2019-01-01 00:00:00', nombre='organizador 5' where login='login_organizador5';

update Miembro set biografia='Biografía de ejemplo de miembro 1.', ubicacion='Jaén' where login='login_miembro1';
update Miembro set biografia='Biografía de ejemplo de miembro 2.', ubicacion='Jaén' where login='login_miembro2';
update Miembro set biografia='Biografía de ejemplo de miembro 3.', ubicacion='Jaén' where login='login_miembro3';
update Miembro set biografia='Biografía de ejemplo de miembro 4.', ubicacion='Jaén' where login='login_miembro4';
update Miembro set biografia='Biografía de ejemplo de miembro 5.', ubicacion='Jaén' where login='login_miembro5';
update Organizador set descripcion='Descripción de ejemplo de organizador.', web='www.organizador.com' where login='login_organizador1';
update Organizador set descripcion='Descripción de ejemplo de organizador.', web='www.organizador.com' where login='login_organizador2';
update Organizador set descripcion='Descripción de ejemplo de organizador.', web='www.organizador.com' where login='login_organizador3';
update Organizador set descripcion='Descripción de ejemplo de organizador.', web='www.organizador.com' where login='login_organizador4';
update Organizador set descripcion='Descripción de ejemplo de organizador.', web='www.organizador.com' where login='login_organizador5';

update Evento set categoria=0, descripcion='primera descr evento', titulo='primer evento', total_asistentes=20, valoracion_media=5.5, web_entradas='www.web.com', organizador='login_organizador1' where id=1;
update Evento set categoria=3, descripcion='segunda descr evento', titulo='segunda evento', total_asistentes=50, valoracion_media=2.5, web_entradas='www.web.com', organizador='login_organizador1' where id=2;
update Evento set categoria=8, descripcion='tercer descr evento', titulo='tercer evento', total_asistentes=10, valoracion_media=7.5, web_entradas='www.web.com', organizador='login_organizador2' where id=3;
update Evento set categoria=3, descripcion='cuarto descr evento', titulo='cuarto evento', total_asistentes=15, valoracion_media=6.5, web_entradas='www.web.com', organizador='login_organizador3' where id=4;

insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (1,'Jaén', 'C/ Av. Andalucia 2','2019-11-15 15:45:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (2,'Madrid', 'C/ Cristobal','2016-11-15 15:00:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (3,'Madrid', 'C/ Cristobal','2020-11-15 15:00:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (4,'Granada', 'C/ Tomero','2015-11-15 15:00:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (5,'Madrid', 'C/ Cristobal','2021-11-15 15:00:00',0.0,0.0,2);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (6,'Jaén', 'C/ Av. Alborotero','2014-11-15 15:00:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (7,'Madrid', 'C/ Av. Alborotero','2020-12-15 15:00:00',0.0,0.0,4);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (8,'Madrid', 'C/ Av. Alborotero','2017-10-15 15:00:00',0.0,0.0,2);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (9,'Granada', 'C/ Av. Alborotero','2019-12-18 15:00:00',0.0,0.0,1);
insert into Sesion (id,ciudad,direccion,fecha,latitud,longitud,evento) VALUES (10,'Madrid', 'C/ Av. Alborotero','2018-11-11 15:00:00',0.0,0.0,2);

insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (1,'Muy buen evento. Felicidades!', '2019-05-10 18:00:00', 8.5, 8, 1, 1, 'login_miembro1');
insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (2,'No es para tanto.', '2019-05-10 19:00:00', 5.0, 0, 4, 1, 'login_miembro2');
insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (3,'Mejorable', '2019-05-10 11:00:00', 4.5, 1, 1, 1, 'login_miembro3');
insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (4,'Buen evento chicos.', '2019-06-10 13:00:00', 6.0, 1, 4, 2, 'login_miembro1');
insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (5,'No me gusta', '2019-05-10 20:00:00', 2.5, 1, 9, 2, 'login_miembro4');
insert into Valoracion (id,comentario,fecha,puntuacion,votos_negativos,votos_positivos,evento,miembro) VALUES (6,'Todo correcto', '2019-05-10 14:00:00', 7.0, 0, 1, 4, 'login_miembro5');

insert into Evento_Guardado (id,fecha,evento,miembro) VALUES (1,'2019-02-02 22:00:00',1,'login_miembro1');
insert into Evento_Guardado (id,fecha,evento,miembro) VALUES (2,'2018-04-16 20:00:00',2,'login_miembro1');
insert into Evento_Guardado (id,fecha,evento,miembro) VALUES (3,'2019-03-01 23:00:00',3,'login_miembro1');
insert into Evento_Guardado (id,fecha,evento,miembro) VALUES (4,'2019-11-11 15:00:00',1,'login_miembro2');
insert into Evento_Guardado (id,fecha,evento,miembro) VALUES (5,'2019-07-04 10:00:00',4,'login_miembro2');

insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro1','login_miembro2');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro1','login_miembro4');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro2','login_miembro1');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro2','login_miembro3');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro2','login_miembro5');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro3','login_miembro4');
insert into Miembros_Seguidos (login_miembro,login_miembro_seguido) VALUES ('login_miembro3','login_miembro5');

insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (1,'2020-02-02 20:00:00',1,'login_miembro1');
insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (2,'2019-03-02 23:00:00',5,'login_miembro1');
insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (3,'2020-04-02 14:00:00',5,'login_miembro2');
insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (4,'2019-02-08 11:00:00',7,'login_miembro2');
insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (5,'2019-09-02 19:00:00',9,'login_miembro4');
insert into Sesion_Apuntada (id,fecha,sesion,miembro) VALUES (6,'2019-12-02 19:00:00',1,'login_miembro4');
