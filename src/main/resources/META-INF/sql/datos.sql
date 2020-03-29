-- Author:  sjm00010
-- Created: 25-mar-2020

-- Inserciones de Veterinarios
insert into Veterinario (codCol,nombre,apellidos,pass,foto) values ('AS0489', 'José Ramón', 'Balsas Almagro', 'admin', 'https://pbs.twimg.com/profile_images/1181225056078385154/A3eO3ove_400x400.jpg');
insert into Veterinario (codCol,nombre,apellidos,pass,foto) values ('AS0008', 'Flo', 'López Ortega', 'francis', 'https://i1.rgstatic.net/ii/profile.image/586016247279622-1516728569350_Q512/F_Charte.jpg');

-- Inserciones de Clientes
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('54215624R','Ángel Luis','García Fernández','Campus Las Lagunillas',TO_DATE('1982-07-26','YYYY-MM-DD'),'https://www.ujaen.es/departamentos/dinformatica/sites/departamento_dinformatica/files/styles/contact_photo/public/uploads/node_contacto_persona/2019-06/algarcia.jpg?itok=VjL78gZO','algarcia@ujaen.es','contrasena');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('53914398T','Francis','Ortega López','La lloreria',TO_DATE('1996-02-17','YYYY-MM-DD'),'https://i.pinimg.com/originals/d9/e9/7d/d9e97d15c8aefb3067372c36fa2abc26.png','fol00008@ujaen.es','paco00008');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('24315522B','Alejandro','Expósito Pontiveros','Avenida Andalucía, 1',TO_DATE('1997-08-02','YYYY-MM-DD'),'https://www.pngitem.com/pimgs/m/204-2040760_contact-starwars-user-default-yoda-comments-users-icon.png','aep00042@ujaen.es','erasmus');
insert into Cliente (DNI,nombre,apellidos,direccion,fnac,foto,email,pass) values ('34209621C','ElRisas','Joker El Bromas','En su casa, algun sitio',TO_DATE('1976-12-30','YYYY-MM-DD'),'https://cdn.businessinsider.es/sites/navi.axelspringer.es/public/styles/1200x895/public/media/image/2019/08/joker.jpeg?itok=5ldLzg71','elbromas@ujaen.es','sanicgo');
