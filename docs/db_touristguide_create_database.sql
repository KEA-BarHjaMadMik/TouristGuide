DROP DATABASE IF EXISTS tourist_guide;
CREATE DATABASE tourist_guide;
USE tourist_guide;

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
        REFERENCES Cities (Zipcode)
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