# A) Henter ut filmID, tittel, produksjonsår og regissørID på alle filmer
SELECT FilmID, Tittel, Produksjonsår, RegissørID FROM Film;

# B) Finner navn på alle skuespillere født senere enn 1960.
SELECT navn FROM Skuespiller 
WHERE Fødselsår > 1960;

# C) Finner navn på alle skuespillere født på 80-tallet, sortert i alfabetisk rekkefølge.
SELECT navn FROM Skuespiller
WHERE Fødselsår BETWEEN 1980 AND 1990
ORDER BY navn ASC;

# D) Finner titlene på alle filmene og de tilhørende rollene som “Morgan Freeman” har spilt.
SELECT tittel, navn, rolle
FROM Film
	NATURAL JOIN SkuespillerIFilm
    NATURAL JOIN Skuespiller
		WHERE Skuespiller.navn = "Morgan Freeman";

# E) Henter ut de distinkte titlene på filmene hvor regissøren og en av skuespillerne i filmen har likt navn
SELECT DISTINCT tittel
FROM SkuespillerIFilm
    NATURAL JOIN Film
    NATURAL JOIN Skuespiller
	JOIN Regissør
		ON Skuespiller.navn = Regissør.navn;

# F) Finner antallet skuespillere som har et navn som starter på “C
SELECT COUNT(*) FROM Skuespiller WHERE navn LIKE "C%";

# G) For hver sjanger finn sjangernavnet og antallet filmer av den sjangeren
SELECT COUNT(FilmID), Sjanger.navn
FROM SjangerForFilm
	NATURAL JOIN Sjanger
		GROUP BY Sjanger.navn;

# H) Finner navnet på skuespillere som har spilt i filmen “Ace Ventura: Pet Detective”, men aldri i filmen “Ace Ventura: When Nature Calls”.
SELECT Skuespiller.navn
FROM SkuespillerIFilm
	NATURAL JOIN Film
    NATURAL JOIN Skuespiller
		WHERE Film.tittel = "Ace Ventura: Pet Detective"
        AND Skuespiller.navn NOT IN (
			SELECT Skuespiller.navn
				FROM SkuespillerIFilm
					NATURAL JOIN Film
					NATURAL JOIN Skuespiller
						WHERE Film.tittel = "Ace Ventura: When Nature Calls"
        );

# I) For hver film finn navnet på filmen, filmID og gjennomsnittlig fødselsår på skuespillerne i filmen. 
# Vi ønsker kun å få med de filmene som har gjennomsnittlig fødselsår større enn gjennomsnittlig fødselsår for alle skuespillerne i databasen.
# (Hint: Her kan det være lurt med en underspørring i en HAVING-del etter aggregeringen).
SELECT FilmID, Film.tittel, AVG(Fødselsår)
FROM SkuespillerIFilm
	NATURAL JOIN Film
    NATURAL JOIN Skuespiller
		GROUP BY FilmID
	
    HAVING AVG(Fødselsår) > (
		SELECT AVG(Fødselsår)
        FROM Skuespiller
    )