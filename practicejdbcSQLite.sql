DROP TABLE enrolled;
DROP TABLE client;
DROP TABLE course
;


CREATE TABLE client (
  codclient int  NOT NULL,
  name varchar(50)  NOT NULL,
  surname varchar(50)  NOT NULL,
  address varchar(100) NOT NULL,
  cell varchar(50) NULL,
  PRIMARY KEY (codclient)
);

CREATE TABLE course
 (
  codcourse
   int NOT NULL,
  nameC varchar(50)  NOT NULL,
  level varchar(50)  NOT NULL,
  cost int NOT NULL,
  availableseats int NOT NULL,
  PRIMARY KEY (codcourse
    )
);


CREATE TABLE enrolled (
  codclient int NOT NULL,
  codicecourse
   int NOT NULL,
  enrolldate date NOT NULL,
  PRIMARY KEY (codclient,codicecourse
    ),
  FOREIGN KEY (codclient) REFERENCES client(codclient),
  FOREIGN KEY (codicecourse
    ) REFERENCES course
  (codcourse
    )
);



INSERT INTO client (codclient, name, surname, address, cell) VALUES (1, 'Christian', 'Drago', 'course
 Abruzzi 50, Torino', '4294967295');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (2, 'Francesco', 'Bianco', 'Via Ignota 71, Milano', '0113336458');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (3, 'Giacomo', 'Neri', 'course
 Roma 125, Torino', '1115484552');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (4, 'Alfredo', 'Bianco', 'course
 Milano 63, Roma', '1214444452');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (5, 'Alessandra', 'Rossi', 'course
 Fantasia 6, Torino', '1215444552');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (6, 'Gianfranco', 'Neri', 'Via Ignoto 5, Milano', '1278244552');
INSERT INTO client (codclient, name, surname, address, cell) VALUES (7, 'Luca', 'Rosso', 'course
 Nuovo 12, Napoli', NULL);
INSERT INTO client (codclient, name, surname, address, cell) VALUES (8, 'Daniele', 'Bianchi', 'course
 Torino 4, Roma', NULL);
INSERT INTO client (codclient, name, surname, address, cell) VALUES (9, 'Gabriela', 'Rossi', 'course
 Lipari 15, Firenze', NULL);
INSERT INTO client (codclient, name, surname, address, cell) VALUES (10, 'Lorenzo', 'Neri', 'Via Genova 114, Torino', NULL);


INSERT INTO course
 (codcourse
  , nameC, level, cost, availableseats) VALUES (1, 'DataBase', 'Avanzato', 100, 4);
INSERT INTO course
 (codcourse
  , nameC, level, cost, availableseats) VALUES (2, 'Java', 'Base', 50, 10);
INSERT INTO course
 (codcourse
  , nameC, level, cost, availableseats) VALUES (3, 'DotNet', 'Intermedio', 75, 20);
INSERT INTO course
 (codcourse
  , nameC, level, cost, availableseats) VALUES (4, 'SistemiOperativi', 'Base', 200, 1);



INSERT INTO enrolled (codclient, codicecourse
  , enrolldate) VALUES (1, 1, DATE('2013-05-18'));
INSERT INTO enrolled (codclient, codicecourse
  , enrolldate) VALUES (1, 2, DATE('2013-05-18'));
INSERT INTO enrolled (codclient, codicecourse
  , enrolldate) VALUES (1, 3, DATE('2013-05-18'));
INSERT INTO enrolled (codclient, codicecourse
  , enrolldate) VALUES (2, 3, DATE('2013-05-18'));
INSERT INTO enrolled (codclient, codicecourse
  , enrolldate) VALUES (3, 3, DATE('2013-05-18'));



