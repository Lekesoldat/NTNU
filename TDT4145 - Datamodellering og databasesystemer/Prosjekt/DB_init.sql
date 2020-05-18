CREATE DATABASE myDB;
USE myDB;

CREATE TABLE Person (
	Fnr INT NOT NULL,
    PRIMARY KEY (Fnr),
    Navn VARCHAR(100),
    Tlf INT(8),
    Fødselsår YEAR,
    Fødselsland VARCHAR(100)
);

CREATE TABLE Musikk (
	MusikkID INT NOT NULL,
    PRIMARY KEY (MusikkID),
    Tittel VARCHAR(100)
);

CREATE TABLE Sjanger (
	SjangerID INT NOT NULL,
    PRIMARY KEY (SjangerID),
    Sjanger VARCHAR(100)
);

CREATE TABLE Selskap (
	SelskapID INT NOT NULL,
    PRIMARY KEY (SelskapID),
    
    URL VARCHAR(100),
    Land VARCHAR(100),
    Addresse VARCHAR(100)
);

CREATE TABLE Bruker (
	BrukerID INT NOT NULL,
    PRIMARY KEY (BrukerID),
    Brukernavn VARCHAR(100)
);

CREATE TABLE Serie (
	SerieID INT NOT NULL,
    PRIMARY KEY (SerieID),
    Tittel VARCHAR(100)
);

CREATE TABLE Sesong (
	Nummer INT,
    SerieID INT,
	FOREIGN KEY (SerieID)
		REFERENCES Serie (SerieID)
		ON DELETE CASCADE,
        
	PRIMARY KEY (Nummer, SerieID)
);

CREATE TABLE Media (
	MediaID INT NOT NULL,
    PRIMARY KEY (MediaID),
    Tittel VARCHAR(100),
    Utgivelsesår YEAR,
    Lanseringsdato DATE,
    Beskrivelse VARCHAR(255),
    Lengde INT,
    
    SelskapID INT,
    FOREIGN KEY (SelskapID) 
		REFERENCES Selskap (SelskapID) 
		ON DELETE CASCADE
);

CREATE TABLE Anmeldelse (
	AnmeldelseID INT NOT NULL,
    PRIMARY KEY (AnmeldelseID),
    Tekst VARCHAR(255),
    Rating INT,
    
    BrukerID INT,
    FOREIGN KEY BrukerID (BrukerID)
		REFERENCES Bruker (BrukerID)
        ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE,
	
    Nummer INT,
	
    SerieID INT,
	FOREIGN KEY (SerieID)
		REFERENCES Serie (SerieID)
        ON DELETE CASCADE
);


# Relations
CREATE TABLE SkuespillerI (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE,
        
	Rolle VARCHAR(100)
);

CREATE TABLE SkrevetAv (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE
);

CREATE TABLE RegiAv (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
		ON DELETE CASCADE
);

CREATE TABLE Komponert (
	Fnr INT,
	FOREIGN KEY (Fnr)
		REFERENCES Person (Fnr)
		ON DELETE CASCADE,
	
    MusikkID INT,
	FOREIGN KEY (MusikkID)
		REFERENCES Musikk (MusikkID)
		ON DELETE CASCADE
);

CREATE TABLE MusikkIMedia (
	MusikkID INT,
	FOREIGN KEY (MusikkID)
		REFERENCES Musikk (MusikkID)
        ON DELETE CASCADE,
        
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE
);

CREATE TABLE EpisodeI (
	MediaID INT,
	FOREIGN KEY (MediaID)
		REFERENCES Media (MediaID)
        ON DELETE CASCADE,
	
    Nummer INT,
	FOREIGN KEY (Nummer)
		REFERENCES Sesong (Nummer)
        ON DELETE CASCADE
);