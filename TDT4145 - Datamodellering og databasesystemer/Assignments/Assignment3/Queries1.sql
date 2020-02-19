USE myDB;

# Regissør(1, “Peyton Reed”)
INSERT INTO regissør values(1, "Peyton Reed");

# Regissør(2, "Tom Shadyac")
INSERT INTO regissør values(2, "Tom Shadyac");

# Film(1, “Yes Man ”, 2008, 1)
INSERT INTO film values(1, "Yes Man", 2008, 1);

# Skuespiller(“1 , “Jim Carrey”, 1962)
INSERT INTO skuespiller values(1, "Jim Carrey", 1962);

# SkuespillerIFilm(1,1, “Carl”)
INSERT INTO skuespillerifilm values(1, 1, "Carl");

# Skriv en SQL-setning som oppdaterer navnet til Jim Carrey til James Eugene Carrey.
UPDATE skuespiller
SET navn = "James Eugene Carrey"
WHERE SkuespillerID = 1;

# Skrive en SQL-setning som sletter Tom Shadyac fra databasen
DELETE FROM regissør
WHERE RegissørID = 2;