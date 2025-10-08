
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS AttractionTags;
DROP TABLE IF EXISTS Tags;
DROP TABLE IF EXISTS Attractions;
DROP TABLE IF EXISTS Cities;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE Cities (
    ZipCode CHAR(4) NOT NULL,
    CityName VARCHAR(30) NOT NULL,
    PRIMARY KEY (ZipCode)
);

CREATE TABLE Attractions (
    AttractionName VARCHAR(100) NOT NULL,
    Description VARCHAR(800) NOT NULL,
    ZipCode CHAR(4) NOT NULL,
    Price FLOAT NULL,
    PRIMARY KEY (AttractionName),
    CONSTRAINT FK_Attractions_ZipCode FOREIGN KEY (ZipCode)
        REFERENCES Cities (ZipCode)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE Tags (
    TagName varchar(55) NOT NULL,
    PRIMARY KEY (TagName)
);


CREATE TABLE AttractionTags (
    AttractionName varchar(100) NOT NULL,
    TagName varchar(55) NOT NULL,
    PRIMARY KEY (AttractionName, TagName),
    CONSTRAINT FK_AttractionTags_AttractionName FOREIGN KEY (AttractionName)
        REFERENCES Attractions (AttractionName)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_AttractionTags_TagName FOREIGN KEY (TagName)
        REFERENCES Tags (TagName)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Cities VALUES('1000', 'København K');
INSERT INTO Cities VALUES('7400', 'Herning');

INSERT INTO Attractions VALUES (
    'Prøvekør Drømmebilen - Porsche 911 Carrera S',
    'Lej din drømmebil for en dag! Oplev drømmen og prøv en af verdens mest berømte biler - Porsche 911 Carrera S. Bilen er i sort metallic med sort læderindtræk og baghjulstræk ligesom en rigtig Porsche 911 skal være.Bilen er desuden udstyret med et sportsudstødningssystem for at få mere lyd i bilen og et Bose lydsystem, så du kan nyde din yndlingsmusik, mens du kører. Udover det er den også udstyret med lir i form af Porsche active suspension management, 8-trins dobbeltkoblingsboks, Apple carplay og glassoltag.',
    '1000',
    2699.0
);

INSERT INTO Attractions VALUES(
    'Tandemspring',
    'Den ultimative oplevelse med et andet menneske! Tag din ven eller kæreste i hånden, spring ud i det og oplev suset i maven sammen. Denne oplevelse vil uden tvivl knytte bånd for livet.

    Vores professionelle og specialuddannede instruktører vil guide jer til at udfordre egne grænser i sikre rammer.

    Et tandemspring er den perfekte anledning til at komme hinanden ved, idet at i fastspændes i hver jeres body-harness, og tager springet sammen.',
    '7400',
    NULL
);

INSERT INTO Tags VALUES ('biler');
INSERT INTO Tags VALUES ('bungeejump');
INSERT INTO Tags VALUES ('fart');
INSERT INTO Tags VALUES ('frit fald');
INSERT INTO Tags VALUES ('fyn');
INSERT INTO Tags VALUES ('gokart');
INSERT INTO Tags VALUES ('højder');
INSERT INTO Tags VALUES ('jylland');
INSERT INTO Tags VALUES ('luksus');
INSERT INTO Tags VALUES ('malmö');
INSERT INTO Tags VALUES ('porsche');
INSERT INTO Tags VALUES ('sjælland');
INSERT INTO Tags VALUES ('snor');
INSERT INTO Tags VALUES ('tandem');

INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'malmö');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'biler');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'porsche');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'fart');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'luksus');

INSERT INTO AttractionTags VALUES ('Tandemspring', 'tandem');
INSERT INTO AttractionTags VALUES ('Tandemspring', 'højder');
INSERT INTO AttractionTags VALUES ('Tandemspring', 'frit fald');