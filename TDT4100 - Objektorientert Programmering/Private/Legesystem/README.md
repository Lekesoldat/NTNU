# Oppgaveforslag til 'helse-tema' for 2019

### Abstrakt ```Person```:
- Unik id
- Fornavn
- Etternavn
- Alder
- Getters & setters
- Pen ```toString()```

### Abstrakt ```Helsearbeider``` arver ```Person```:
- Unik arbeider-id
- Getters
- Abstrakt metode getTittel()
- Pen ```toString()```

### ```Pasient``` arver ```Person``` implementerer ```Prioritet```:
- Liste over resepter
- Fastlege-link
- Getters & setters
- Pen ```toString()```

### ```Lege``` utvider ```Helsearbeider```:
- Liste med pasienter
- Liste med utskrevne resepter
- Getters & setters
- Metoder for å adde resepter
- Metoder for å adde og fjerne pasienter
- Pen ```toString()```

### ```Sykepleier``` utvider ```Helsearbeider```:
- Har ikke gjort noe med denne enda, men kan være nyttig senere

### Interface ```Prioritet```:
- Metode som returnerer et tall som avgjør prioriteten
- (Ment å bruke for å sortere senere)

—————————————————————————————————

### ```Legemiddel```:
- Unik id
- Navn
- Mengde

### Abstrakt ```Resept```:
- Unik id
- Link til utskrivende lege
- Link til pasient utskrevet til
- Link til legemiddel
- Pris
- Reit
- Getters
- Abstrakt metode for å hente pris (avhenger av blå eller hvit resept)
- Abstrakt metode for å hente type (blå eller hvit)
- Pen ```toString()```

### ```BlaaResept``` arver ```Resept```:
- Implementerer type
- Implementerer pris
- Pen ```toString()```

### ```HvitResept``` arver ```Resept```:
- Implementerer type
- Implementerer pris
- Pen ```toString()```

—————————————————————————————————

### ```Sykehus```:
- Liste med alle leger
- Liste med alle pasienter
- Liste med alle resepter (kan være i en apotek-klasse)
- Liste med alle legemidler (kan være i en apotek-klasse)
- Liste med alle avdelinger
- Metoder for å legge til og fjerne pasienter på avdeling
- Kø med pasienter som venter på rom
- Pen ```toString()```

### ```Avdeling```:
- Unik id
- Prioritetsnivå (hva slags pasienter som er her)
- Liste med rom
- Metoder for å legge til og fjerne pasienter på rom
- Pen ```toString()```

### ```Rom```:
- Unik id
- Liste med sengeplasser
- Metoder for å legge til og fjerne pasienter i seng
- Pen ```toString()```


Tanken er å implementere noe observable-greier på sykehuset og avdelingene, så man kan få lagt til pasienter der det trengs basert på prioritet osv, - vet ikke helt enda.

Om man er suicidal kan man prøve å skrive alt dette til fil og lese inn igjen.


### Temaer dekket:
- Modifikatorer
    - Synlighet, abstract, final, static
- Arv
- Grensesnitt
    - Funksjonelt grensesnitt
    - Comparator
    - Iterator om ønsket
- Observable og delegering
- Konstruktører og metoder mm.
