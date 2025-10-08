USE adrenalinedanmark;

SET FOREIGN_KEY_CHECKS = 0;  -- disables foreign key checks
TRUNCATE TABLE Cities;
SET FOREIGN_KEY_CHECKS = 1;  -- enables foreign key checks

INSERT INTO Cities VALUES('1000', 'København K');
INSERT INTO Cities VALUES('8000', 'Aarhus');
INSERT INTO Cities VALUES('5000', 'Odense');
INSERT INTO Cities VALUES('9000', 'Aalborg');
INSERT INTO Cities VALUES('6700', 'Esbjerg');
INSERT INTO Cities VALUES('8900', 'Randers');
INSERT INTO Cities VALUES('6000', 'Kolding');
INSERT INTO Cities VALUES('8700', 'Horsens');
INSERT INTO Cities VALUES('7100', 'Vejle');
INSERT INTO Cities VALUES('4000', 'Roskilde');
INSERT INTO Cities VALUES('7400', 'Herning');
INSERT INTO Cities VALUES('2970', 'Hørsholm');
INSERT INTO Cities VALUES('3000', 'Helsingør');
INSERT INTO Cities VALUES('8600', 'Silkeborg');
INSERT INTO Cities VALUES('4700', 'Næstved');
INSERT INTO Cities VALUES('7000', 'Fredericia');
INSERT INTO Cities VALUES('2750', 'Ballerup');
INSERT INTO Cities VALUES('2720', 'Vanløse');
INSERT INTO Cities VALUES('2920', 'Charlottenlund');
INSERT INTO Cities VALUES('2670', 'Greve');
INSERT INTO Cities VALUES('2800', 'Lyngby');
INSERT INTO Cities VALUES('2630', 'Taastrup');
INSERT INTO Cities VALUES('2650', 'Hvidovre');
INSERT INTO Cities VALUES('3400', 'Hillerød');
INSERT INTO Cities VALUES('7500', 'Holstebro');
INSERT INTO Cities VALUES('4200', 'Slagelse');
INSERT INTO Cities VALUES('2620', 'Albertslund');
INSERT INTO Cities VALUES('6400', 'Sønderborg');
INSERT INTO Cities VALUES('5700', 'Svendborg');
INSERT INTO Cities VALUES('5800', 'Nyborg');
INSERT INTO Cities VALUES('2600', 'Glostrup');
INSERT INTO Cities VALUES('7800', 'Skive');
INSERT INTO Cities VALUES('9400', 'Nørresundby');
INSERT INTO Cities VALUES('9900', 'Frederikshavn');
INSERT INTO Cities VALUES('4400', 'Kalundborg');
INSERT INTO Cities VALUES('4100', 'Ringsted');
INSERT INTO Cities VALUES('3660', 'Stenløse');
INSERT INTO Cities VALUES('3520', 'Farum');
INSERT INTO Cities VALUES('6800', 'Varde');
INSERT INTO Cities VALUES('2840', 'Rudersdal');
INSERT INTO Cities VALUES('2000', 'Frederiksberg');
INSERT INTO Cities VALUES('2605', 'Brøndby');
INSERT INTO Cities VALUES('7700', 'Thisted');
INSERT INTO Cities VALUES('8660', 'Skanderborg');
INSERT INTO Cities VALUES('4600', 'Køge');
INSERT INTO Cities VALUES('8800', 'Viborg');
INSERT INTO Cities VALUES('3460', 'Birkerød');
INSERT INTO Cities VALUES('3700', 'Rønne');
INSERT INTO Cities VALUES('5500', 'Middelfart');
INSERT INTO Cities VALUES('2791', 'Dragør');
INSERT INTO Cities VALUES('7200', 'Grindsted');
INSERT INTO Cities VALUES('2640', 'Hedehusene');
INSERT INTO Cities VALUES('6760', 'Ribe');
INSERT INTO Cities VALUES('6270', 'Tønder');
INSERT INTO Cities VALUES('6100', 'Haderslev');
INSERT INTO Cities VALUES('7430', 'Ikast');
INSERT INTO Cities VALUES('2680', 'Solrød');
INSERT INTO Cities VALUES('8410', 'Rønde');
INSERT INTO Cities VALUES('3500', 'Værløse');
INSERT INTO Cities VALUES('3650', 'Ølstykke');
INSERT INTO Cities VALUES('2625', 'Vallensbæk');
INSERT INTO Cities VALUES('4800', 'Nykøbing Falster');
INSERT INTO Cities VALUES('7900', 'Nykøbing Mors');
INSERT INTO Cities VALUES('3200', 'Helsinge');
INSERT INTO Cities VALUES('6200', 'Aabenraa');
INSERT INTO Cities VALUES('4300', 'Holbæk');
INSERT INTO Cities VALUES('3600', 'Frederikssund');
INSERT INTO Cities VALUES('2770', 'Kastrup');
INSERT INTO Cities VALUES('5300', 'Kerteminde');
INSERT INTO Cities VALUES('4690', 'Haslev');
INSERT INTO Cities VALUES('4040', 'Jyllinge');
INSERT INTO Cities VALUES('4760', 'Vordingborg');
INSERT INTO Cities VALUES('4180', 'Sorø');
INSERT INTO Cities VALUES('9990', 'Skagen');
INSERT INTO Cities VALUES('3050', 'Humlebæk');
INSERT INTO Cities VALUES('3060', 'Espergærde');
INSERT INTO Cities VALUES('3230', 'Græsted');
INSERT INTO Cities VALUES('3250', 'Gilleleje');
INSERT INTO Cities VALUES('3220', 'Tisvildeleje');
INSERT INTO Cities VALUES('3480', 'Fredensborg');
INSERT INTO Cities VALUES('3450', 'Allerød');
INSERT INTO Cities VALUES('8362', 'Hørning');
INSERT INTO Cities VALUES('8310', 'Tranbjerg');
INSERT INTO Cities VALUES('8320', 'Mårslet');
INSERT INTO Cities VALUES('8340', 'Malling');
INSERT INTO Cities VALUES('8330', 'Beder');
INSERT INTO Cities VALUES('8250', 'Egå');
INSERT INTO Cities VALUES('8240', 'Risskov');
INSERT INTO Cities VALUES('8220', 'Brabrand');
INSERT INTO Cities VALUES('8230', 'Åbyhøj');
INSERT INTO Cities VALUES('8270', 'Højbjerg');
INSERT INTO Cities VALUES('8260', 'Viby');
INSERT INTO Cities VALUES('8381', 'Tilst');
INSERT INTO Cities VALUES('8380', 'Trige');
INSERT INTO Cities VALUES('8382', 'Hinnerup');
INSERT INTO Cities VALUES('8520', 'Lystrup');

SET FOREIGN_KEY_CHECKS = 0;  -- disables foreign key checks
TRUNCATE TABLE Attractions;
SET FOREIGN_KEY_CHECKS = 1;  -- enables foreign key checks

INSERT INTO Attractions VALUES(
	'Gokart',
    'Oplev fart, sjov og adrenalin på vores gokartbane! Udfordr venner, familie eller kolleger i spændende løb, hvor skarpe sving og høj fart giver den ultimative køreglæde. Perfekt til både nybegyndere og fartentusiaster.',
    '7800',
    NULL
);

INSERT INTO Attractions VALUES(
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

INSERT INTO Attractions VALUES(
	'Bungeejump',
    'Få et adrenalinsus ud over det sædvanlige med Københavns vildeste oplevelse: bungee jump fra en kran på hele 69 meters højde midt på Refshaleøen. Her får du en unik kombination af fart, frihed og udsigt – du svæver frit med Københavns skyline, havnen og Øresund som baggrund.
    
    Uanset om du er erfaren eventyrer eller førstegangshopper, står professionelle instruktører klar til at guide dig trygt gennem oplevelsen. Alt sikkerhedsudstyr er inkluderet, og du får en oplevelse, der garanteret sætter sig på nethinden for livet.
    
    Perfekt som gave, som en grænseoverskridende udfordring til dig selv – eller som et uforglemmeligt højdepunkt på dit besøg i København.
    
    Er du klar til at tage springet?',
    '1000',
    645.0
);

SET FOREIGN_KEY_CHECKS = 0;  -- disables foreign key checks
TRUNCATE TABLE Tags;
SET FOREIGN_KEY_CHECKS = 1;  -- enables foreign key checks

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

SET FOREIGN_KEY_CHECKS = 0;  -- disables foreign key checks
TRUNCATE TABLE AttractionTags;
SET FOREIGN_KEY_CHECKS = 1;  -- enables foreign key checks

INSERT INTO AttractionTags VALUES ('Gokart', 'gokart');
INSERT INTO AttractionTags VALUES ('Gokart', 'jylland');
INSERT INTO AttractionTags VALUES ('Gokart', 'fart');

INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'malmö');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'biler');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'porsche');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'fart');
INSERT INTO AttractionTags VALUES ('Prøvekør Drømmebilen - Porsche 911 Carrera S', 'luksus');

INSERT INTO AttractionTags VALUES ('Tandemspring', 'tandem');
INSERT INTO AttractionTags VALUES ('Tandemspring', 'højder');
INSERT INTO AttractionTags VALUES ('Tandemspring', 'frit fald');

INSERT INTO AttractionTags VALUES ('Bungeejump', 'bungeejump');
INSERT INTO AttractionTags VALUES ('Bungeejump', 'sjælland');
INSERT INTO AttractionTags VALUES ('Bungeejump', 'snor');