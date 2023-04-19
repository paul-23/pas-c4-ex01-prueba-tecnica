DROP TABLE IF EXISTS usuarios;
DROP table IF EXISTS videojuegos;
DROP table IF EXISTS partidas;
DROP table IF EXISTS mensajes;

CREATE TABLE usuarios (
  id_usuario INT PRIMARY KEY,
  nombre_usuario VARCHAR(50),
  correo_electronico VARCHAR(100),
  contrasena VARCHAR(50)
);

CREATE TABLE videojuegos (
  id_videojuego INT PRIMARY KEY,
  nombre_videojuego VARCHAR(50)
);

CREATE TABLE partidas (
  id_partida INT PRIMARY KEY,
  nombre_partida VARCHAR(50),
  id_usuario_creador INT,
  id_videojuego INT,
  CONSTRAINT usuario_creador_partida_fk FOREIGN KEY (id_usuario_creador) REFERENCES usuarios(id_usuario),
  CONSTRAINT videojuego_partida_fk FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id_videojuego)
);

CREATE TABLE usuarios_en_partidas (
  id_usuario_partida INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  id_partida INT,
  CONSTRAINT usuario_uep_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
  CONSTRAINT partida_uep_fk FOREIGN KEY (id_partida) REFERENCES partidas(id_partida)
);

CREATE TABLE mensajes (
  id_mensaje INT PRIMARY KEY AUTO_INCREMENT,
  contenido_mensaje VARCHAR(255),
  id_partida INT,
  id_usuario_emisor INT,
  CONSTRAINT partida_mensajes_fk FOREIGN KEY (id_partida) REFERENCES partidas(id_partida),
  CONSTRAINT usuario_emisor_mensajes_fk FOREIGN KEY (id_usuario_emisor) REFERENCES usuarios(id_usuario)
);

INSERT INTO usuarios (id_usuario, nombre_usuario, correo_electronico, contrasena) VALUES
(1, 'Paul', 'paul@gmail.com', 'paul123'),
(2, 'Jose', 'jose@gmail.com', 'joseContraseña'),
(3, 'Josep', 'josep@gmail.com', 'JosepElDeSistemas');

INSERT INTO videojuegos (id_videojuego, nombre_videojuego) VALUES
(1, 'PUBG'),
(2, 'League of Legends'),
(3, 'Minecraft');

INSERT INTO partidas (id_partida, id_usuario_creador, id_videojuego, nombre_partida) VALUES
(1, 1, 1, 'sala29 PUBG'),
(2, 2, 3, 'party_tsystems Minecraft'),
(3, 3, 2, 'Sala LOL');

INSERT INTO usuarios_en_partidas (id_usuario_partida, id_usuario, id_partida) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 2, 1);

INSERT INTO mensajes (id_mensaje, id_partida, id_usuario_emisor, contenido_mensaje) VALUES
(1, 1, 1, 'Eii, ¿quien se echa un pugb?'),
(2, 1, 2, 'Yoo, dalee!'),
(3, 3, 2, '¿Alguien hace unos juegos del hambre en Minecraft?'),
(4, 2, 3, 'quien un lol?'),
(5, 1, 1, 'Nos falta uno para ser 4 en el PUBG, quien se apunta?');
