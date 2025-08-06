CREATE TABLE usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255),
  email VARCHAR(255),
  contrasena VARCHAR(255),
  fecha_registro DATETIME,
  PRIMARY KEY (id),
  UNIQUE (email)
);

CREATE TABLE topicos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255),
  mensaje TEXT,
  autor VARCHAR(255),
  curso VARCHAR(255),
  fecha_creacion DATETIME,
  status VARCHAR(255),
  PRIMARY KEY (id)
);
