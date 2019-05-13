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
- Liste med alt helsepersonell
- Liste med alle resepter (kan være i en apotek-klasse)
- Liste med alle legemidler (kan være i en apotek-klasse)
- Liste med alle avdelinger
- Liste over lyttere
- Funksjonalitet for å gi en notifikasjon til lytterne dersom kapasiteten endres.
- Pen ```toString()```

### ```Avdeling```:
- Unik id
- Prioritetsnivå (hva slags pasienter som er her)
- Liste med rom
    - La dette være representert ved et person-array med størrelse lik 'antallRom'.
- Metoder for å legge til og fjerne pasienter på rom
- Pen ```toString()```

### ```Saksbehandler``` som implementerer det funksjonelle grensesnittet ```KapasitetLytter```
- Skal fungere som en lytter på sykehuset.
- Skal forsøke å plassere pasienter på sykehuset.
    - Om de ikke får plass, legg dem i kø.
- Skal også kunne fjerne pasienter.


## Temaer dekket:
- Modifikatorer
    - Synlighet, abstract, final, static
- Arv
- Grensesnitt
    - Funksjonelt grensesnitt
    - Comparator - DENNE MANGLER ENN SÅ LENGE
    - Iterator om ønsket
- Observable og delegering
- Konstruktører og metoder mm.
