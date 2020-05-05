-- Author:  sjm00010
-- Created: 25-mar-2020

-- Inserciones de Veterinarios
insert into Veterinario (codCol,nombre,apellidos,pass,foto) values ('AS0489', 'José Ramón', 'Balsas Almagro', 'admin', 'https://pbs.twimg.com/profile_images/1181225056078385154/A3eO3ove_400x400.jpg');
insert into Veterinario (codCol,nombre,apellidos,pass,foto) values ('AS0008', 'Flo', 'López Ortega', 'francis', 'https://i1.rgstatic.net/ii/profile.image/586016247279622-1516728569350_Q512/F_Charte.jpg');

-- Inserciones de Clientes
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('54215624R','Ángel Luis','García Fernández','Campus Las Lagunillas','1982-07-26','https://www.ujaen.es/departamentos/dinformatica/sites/departamento_dinformatica/files/styles/contact_photo/public/uploads/node_contacto_persona/2019-06/algarcia.jpg?itok=VjL78gZO','algarcia@ujaen.es','contrasena');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('53914398T','Francis','Ortega López','La lloreria','1996-02-17','https://i.pinimg.com/originals/d9/e9/7d/d9e97d15c8aefb3067372c36fa2abc26.png','fol00008@ujaen.es','paco00008');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('24315522B','Alejandro','Expósito Pontiveros','Avenida Andalucía, 1','1997-08-02','https://www.pngitem.com/pimgs/m/204-2040760_contact-starwars-user-default-yoda-comments-users-icon.png','aep00042@ujaen.es','erasmus');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('34209621C','ElRisas','Joker El Bromas','En su casa, algun sitio','1976-12-30','https://cdn.businessinsider.es/sites/navi.axelspringer.es/public/styles/1200x895/public/media/image/2019/08/joker.jpeg?itok=5ldLzg71','elbromas@ujaen.es','sanicgo');

-- Inserciones de Cita
insert into Cita (fecha,hora,cliDNI,vetCC,masCI) VALUES ('2020-05-08','16:00','54215624R','AS0008','938000000455987'); 
insert into Cita (fecha,hora,cliDNI,vetCC,masCI) VALUES ('2020-05-05','10:00','54215624R','AS0489','938000000455987'); 
insert into Cita (fecha,hora,cliDNI,vetCC,masCI) VALUES ('2020-05-05','9:00','53914398T','AS0008','938000777000666'); 
insert into Cita (fecha,hora,cliDNI,vetCC,masCI) VALUES ('2020-07-15','17:00','54215624R','AS0489','938000000455987'); 
insert into Cita (fecha,hora,cliDNI,vetCC,masCI) VALUES ('2020-09-01','12:00','53914398T','AS0008','938000777000666');

-- Inserciones de Mascotas
insert into Mascota (ci,nombre,raza,especie,sexo,altura,peso,fechanac,foto,cliDNI,vetCC) VALUES ('938000000455987', 'Remy', 'Domestica', 'Rata', 'Macho', 12, 230, '2008-07-26', 'https://vignette.wikia.nocookie.net/dominios-encantados/images/6/66/REMY_WIKI.png/revision/latest/scale-to-width-down/340?cb=20151126195355&path-prefix=es', '54215624R', 'AS0008');
insert into Mascota (ci,nombre,raza,especie,sexo,altura,peso,fechanac,foto,cliDNI,vetCC) VALUES ('938000159457532', 'Misifu', 'Ragdoll', 'Gato', 'Hembra', 25, 3800, '2003-08-08', 'https://i.pinimg.com/originals/c3/3d/0b/c33d0bbefe1e6a22474e40726b0c7955.png', '54215624R', 'AS0489');
insert into Mascota (ci,nombre,raza,especie,sexo,altura,peso,fechanac,foto,cliDNI,vetCC) VALUES ('938000777000666', 'Pipo', 'Gambino', 'Perro', 'Macho', 60, 6000, '2015-11-17', 'https://i1.sndcdn.com/artworks-000239253704-ikgw8q-t500x500.jpg', '53914398T', 'AS0008');