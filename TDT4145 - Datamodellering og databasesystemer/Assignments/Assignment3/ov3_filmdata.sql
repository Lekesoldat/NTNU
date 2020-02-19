INSERT INTO regissør VALUES(1, "Peyton Reed"),(2, "Tom Shadyac"),(3, "Steve Oedekerk"),(4, "Christopher Nolan"), (5, "Gunhild Nordmann");

INSERT INTO film values(1, "Yes Man", 2008, 1), (2, "Ace Ventura: When Nature Calls", 1995, 3),(3, "Ace Ventura: Pet Detective", 1994, 2),
(4, "Bruce Almighty", 2003, 2), (5, "The Dark Knight", 2008, 4), (6, "Batman Begins", 2005, 4), (7, "En eksamenvakts dagbok", 2014, 5);

INSERT INTO sjanger values(1, "Komedie", "Får deg til å skratte, humre og knegge. Du vil føle deg levende."), (2, "Romantikk", "Varmer hjertet."),
(3,"Eventyr","Det gjelder å oppdage for å oppleve."),(4, "Krim", null), (5,"Fantasi", "Hvor går grensene?"), (6, "Drama", "Dramatikk."),
(7,"Action", "Fyr og flamme."), (8,"Thriller", "Filmer som forårsaker (behagelige) gys og en spennende opplevelse.");


INSERT INTO SjangerForFilm values(1,1),(1,2),(1,3),(1,4),(2,1),(3,2),(3,6),(4,2),(4,5),(5,4),(6,4),(6,5),(7,5),(7,6),(8,6),
(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7); -- format: (SjangerID, FilmID)


INSERT INTO skuespiller values(1, "Jim Carrey", 1962),(2, "Zooey Deschanel", 1980), (3, "Bradley Cooper", 1975),
(4, "John Michael Higgins", 1963), (5, "Rhys Darby", 1974), (6, "Ian McNeice", 1950), (7, "Simon Callow", 1949),
(8, "Maynard Eziashi", 1965), (9, "Bob Gunton", 1945), (10, "Courtney Cox", 1964), (11, "Sean Young", 1959), (12, "Tone Loc", 1966),
(13, "Dan Marino", 1961), (14,"Morgan Freeman", 1937), (15, "Jennifer Aniston", 1969),(16, "Philip Baker Hall", 1931),
(17, "Catherine Bell", 1968), (18, "Christian Bale", 1974), (19, "Heath Ledger", 1979), (20, "Aaron Eckhart", 1968),
(21, "Michael Caine", 1933), (22, "Liam Neeson", 1952), (23, "Katie Holmes", 1978), (24, "Gary Oldman", 1958), (25, "Gunhild Nordmann", 1941), 
(26, "Gunhild Nordmann", 1941);


INSERT INTO skuespillerifilm values(1,1,"Carl"), (1,2,"Allison"), (1,3,"Peter"), (1,4,"Nick"), (1,5, "Norman"), (2,1,"Ace Ventura"),
(2,6,"Fulton Greenwall"), (2,7,"Vincent Cadby"), (2,8,"Ouda"), (2,9,"Burton Quinn"), (3,1,"Ace Ventura"), (3,10, "Melissa"),
(3,11, "Lt. Lois Einhorn"), (3,12, "Emilio"), (3,13, "Dan Marino"), (4,1,"Bruce Nolan"), (4, 14, "God"),(4,15,"Grace"),
(4,16, "Jack"), (4, 17, "Susan"), (5, 18, "Bruce Wayne"), (5, 19, "Joker"), (5,20, "Harvey Dent"), (5, 21, "Alfred"), (5,14, "Lucius Fox"),
(5,24, "Gordon"), (6,18, "Bruce Wayne"), (6,14, "Lucius Fox"), (6,21, "Alfred"), (6, 22, "Ducard"), (6,23, "Rachel Dawes"), 
(6,24, "Gordon"),(7,25,"Hovedperson"), (7, 26, "Biperson"); -- format: (FilmID, SkuespillerID, Rolle)
