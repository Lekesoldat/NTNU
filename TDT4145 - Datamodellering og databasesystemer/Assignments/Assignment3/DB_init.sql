# CREATE DATABASE myDB;
USE myDB;
DROP TABLE film, sjanger, skuespiller, regissør, sjangerforfilm, regissørifilm, skuespillerifilm;

CREATE TABLE Film (
	FilmID int NOT NULL,
    PRIMARY KEY (FilmID),
    Tittel varchar(255),
    Produksjonsår YEAR,
    RegissørID int
);

CREATE TABLE Sjanger (
	SjangerID int NOT NULL,
    PRIMARY KEY (SjangerID),
    Navn varchar(255),
    Beskrivelse varchar(255)
);

CREATE TABLE Skuespiller (
	SkuespillerID int NOT NULL,
    PRIMARY KEY (SkuespillerId),
    Navn varchar(255),
    Fødselsår YEAR
);

CREATE TABLE Regissør (
	RegissørID int NOT NULL,
    PRIMARY KEY (RegissørID),
    Navn varchar(255)
);

CREATE TABLE SjangerForFilm (
	SjangerID int NOT NULL,
	FOREIGN KEY (SjangerID)
		REFERENCES Sjanger (SjangerID)
        ON DELETE CASCADE,
        
    FilmID int NOT NULL,
    FOREIGN KEY (FilmID)
		REFERENCES Film (FilmID)
        ON DELETE CASCADE
);

CREATE TABLE SkuespillerIFilm (
	FilmID int NOT NULL,
	FOREIGN KEY (FilmID)
		REFERENCES Film (FilmID)
        ON DELETE CASCADE,
        
	SkuespillerID int NOT NULL,
    FOREIGN KEY (SkuespillerID)
		REFERENCES Skuespiller (SkuespillerID)
        ON DELETE CASCADE,
        
	Rolle varchar(60)
);

CREATE TABLE RegissørIFilm (
	RegissørID int NOT NULL,
	FOREIGN KEY (RegissørID)
		REFERENCES Regissør (RegissørID)
        ON DELETE CASCADE,
        
    FilmID int NOT NULL,
    FOREIGN KEY (FilmID)
		REFERENCES Film (FilmID)
        ON DELETE CASCADE
);
