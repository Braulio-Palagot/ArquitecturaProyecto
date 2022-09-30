CREATE SCHEMA IF NOT EXISTS `casoEstudioBD` DEFAULT CHARACTER SET utf8 ;
USE `casoEstudioBD` ;
CREATE DATABASE IF NOT EXISTS casoEstudioBD;
USE casoEstudioBD;
DROP TABLE IF EXISTS Usuario, Ponencia,Evento,Comentario,Encuesta,Fondos;
FLUSH TABLES exclude;

CREATE TABLE Usuario (
                ID_Usuario INT AUTO_INCREMENT NOT NULL,
                nombreUsuario VARCHAR(20) NOT NULL,
                Correo VARCHAR(50) NOT NULL,
                apellidoPaternoUsuario VARCHAR(30) NOT NULL,
                apellidoMaternoUsuario VARCHAR(30) NOT NULL,
                PRIMARY KEY (ID_Usuario)
);


CREATE TABLE Ponencia (
                ID_Ponencia INT AUTO_INCREMENT NOT NULL,
                tema VARCHAR(50) NOT NULL,
                documentacion VARCHAR(50) NOT NULL,
                materialApoyo VARCHAR(60) NOT NULL,
                PRIMARY KEY (ID_Ponencia)
);


CREATE TABLE Evento (
                ID_Evento INT AUTO_INCREMENT NOT NULL,
                direccion VARCHAR(60) NOT NULL,
                fecha DATE NOT NULL,
                ID_Ponencia int NOT NULL,
                ID_Fondos int NOT NULL,
                ID_Usuario INT NOT NULL,
                CONSTRAINT ID_Evento PRIMARY KEY (ID_Evento)
);


CREATE TABLE Comentario (
                ID_Comentario INT AUTO_INCREMENT NOT NULL,
                Valoracion NUMERIC NOT NULL,
                Comentario VARCHAR(60) NOT NULL,
                ID_Evento int NOT NULL,
                ID_Usuario INT NOT NULL,
                CONSTRAINT ID_Comentario PRIMARY KEY (ID_Comentario)
);


CREATE TABLE Encuesta (
                ID_Encuesta int auto_increment NOT NULL,
                Respuesta varchar(100) NOT NULL,
                ID_Evento int NOT NULL,
                ID_Ponencia int NOT NULL,
                PRIMARY KEY (ID_Encuesta)
);


CREATE TABLE Fondos (
                ID_Fondos INT auto_increment NOT NULL,
                insumo VARCHAR(20) NOT NULL,
                ID_Evento NUMERIC NOT NULL,
                PRIMARY KEY (ID_Fondos)
);


ALTER TABLE Evento ADD CONSTRAINT Usuario_Evento_fk
FOREIGN KEY (ID_Usuario)
REFERENCES Usuario (ID_Usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Comentario ADD CONSTRAINT Usuario_Comentario_fk
FOREIGN KEY (ID_Usuario)
REFERENCES Usuario (ID_Usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Evento ADD CONSTRAINT Ponencia_Evento_fk
FOREIGN KEY (ID_Ponencia)
REFERENCES Ponencia (ID_Ponencia)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Encuesta ADD CONSTRAINT Ponencia_Encuesta_fk
FOREIGN KEY (ID_Ponencia)
REFERENCES Ponencia (ID_Ponencia)
ON DELETE NO ACTION
ON UPDATE NO ACTION;


ALTER TABLE Encuesta ADD CONSTRAINT Evento_Encuesta_fk
FOREIGN KEY (ID_Evento)
REFERENCES Evento (ID_Evento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Comentario ADD CONSTRAINT Evento_Comentario_fk
FOREIGN KEY (ID_Evento)
REFERENCES Evento (ID_Evento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

INSERT INTO `casoestudiobd`.`usuario` (`ID_Usuario`, `nombreUsuario`, `Correo`, `apellidoPaternoUsuario`, `apellidoMaternoUsuario`) VALUES ('1', 'Aldo', 'ajzvporta123@gmail.com', 'Sanchez', 'Benitez');
INSERT INTO `casoestudiobd`.`usuario` (`ID_Usuario`, `nombreUsuario`, `Correo`, `apellidoPaternoUsuario`, `apellidoMaternoUsuario`) VALUES ('2', 'Braulio', 'brau@gmail.com', 'Palagot ', 'Hernandez');
INSERT INTO `casoestudiobd`.`usuario` (`ID_Usuario`, `nombreUsuario`, `Correo`, `apellidoPaternoUsuario`, `apellidoMaternoUsuario`) VALUES ('3', 'Jocelyn', 'joce', 'Flores', 'Lopez');

INSERT INTO `casoestudiobd`.`ponencia` (`ID_Ponencia`, `tema`, `documentacion`, `materialApoyo`) VALUES ('1', 'Es carrera no carrerita', 'Hablaremos sobre como la vida universitaria no es lo que siempre esperas', 'Presentación');
INSERT INTO `casoestudiobd`.`ponencia` (`ID_Ponencia`, `tema`, `documentacion`, `materialApoyo`) VALUES ('2', 'Como ser creativo', 'Tocaremos el tema de como podemos activar nuestra creatividad', 'Presentación');
INSERT INTO `casoestudiobd`.`ponencia` (`ID_Ponencia`, `tema`, `documentacion`, `materialApoyo`) VALUES ('3', 'No eres el centro de atención', 'Trataremos de abarcar el tema de que no siempre las cosas salen como quieres', 'Video, Presentación');

INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('1', 'Silla', '1');
INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('2', 'Proyector', '1');
INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('3', 'Bocinas', '2');
INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('4', 'Sillas', '3');
INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('5', 'Proyector', '2');
INSERT INTO `casoestudiobd`.`fondos` (`ID_Fondos`, `insumo`, `ID_Evento`) VALUES ('6', 'Bocinas', '2');

INSERT INTO `casoestudiobd`.`evento` (`ID_Evento`, `direccion`, `fecha`, `ID_Ponencia`, `ID_Fondos`, `ID_Usuario`) VALUES ('1', 'Calle Enrique Segoviano', '2022-09-30', '1', '1', '1');
INSERT INTO `casoestudiobd`.`evento` (`ID_Evento`, `direccion`, `fecha`, `ID_Ponencia`, `ID_Fondos`, `ID_Usuario`) VALUES ('2', 'ITO', '2022-09-09', '2', '3', '2');
INSERT INTO `casoestudiobd`.`evento` (`ID_Evento`, `direccion`, `fecha`, `ID_Ponencia`, `ID_Fondos`, `ID_Usuario`) VALUES ('3', 'ITO', '2022-09-28', '3', '4', '3');

INSERT INTO `casoestudiobd`.`encuesta` (`ID_Encuesta`, `Respuesta`, `ID_Evento`, `ID_Ponencia`) VALUES ('1', 'Me gusto mucho el evento', '1', '1');
INSERT INTO `casoestudiobd`.`encuesta` (`ID_Encuesta`, `Respuesta`, `ID_Evento`, `ID_Ponencia`) VALUES ('2', 'Puede mejorar', '2', '2');
INSERT INTO `casoestudiobd`.`encuesta` (`ID_Encuesta`, `Respuesta`, `ID_Evento`, `ID_Ponencia`) VALUES ('3', 'No me gusto para nada', '3', '3');

INSERT INTO `casoestudiobd`.`comentario` (`ID_Comentario`, `Valoracion`, `Comentario`, `ID_Evento`, `ID_Usuario`) VALUES ('1', '10', 'Me gusto mucho el evento', '1', '1');
INSERT INTO `casoestudiobd`.`comentario` (`ID_Comentario`, `Valoracion`, `Comentario`, `ID_Evento`, `ID_Usuario`) VALUES ('2', '8', 'Muy impuntuales', '2', '2');
INSERT INTO `casoestudiobd`.`comentario` (`ID_Comentario`, `Valoracion`, `Comentario`, `ID_Evento`, `ID_Usuario`) VALUES ('3', '6', 'Falto mas organizacion', '3', '3');