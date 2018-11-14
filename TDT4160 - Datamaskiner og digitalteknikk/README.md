# TDT4160 - Datamaskiner og Digitalteknikk

- Ikke gå i forelesninger.
- Om du går i forelesninger, kos deg med dette: https://olavbb.com/ggk
- Øv på eksamensoppgaver, samme hvert år.


# Eksamensøving - (Takk [@niklasmh](https://github.com/niklasmh/ntnu/tree/master/TDT4160%20-%20Datamaskiner%20og%20Digitalteknikk/))

## Forkortelser og forklaringer

- **IJVM** - (Integer Java Virtual Machine)
- **ALU** - (Arithmetic Logic Unit)
- **MPC** - (Micro Program Counter)
- **P-ROM / PROM** - (Programmable Read Only Memory)
- **EP-ROM / EPROM** - (Eraseable Programmable Read Only Memory). En type ROM hvor innholdet slettes ved hjelp av sterkt utrafiolett lys (UV).
- **EEP-ROM / EEPROM** - (Electrically Erasable Programmable Read-Only Memory). ROM som kan omprogrammeres. Brukes ofte i mikrokontrollere.
- **ISA** - (Instruction Set Architecture)
  - **RISC** - (Reduced Instruction Set Computing). Utfører få instruksjoner, hver instruksjon tar kort tid.
    - **Instruksjonsstørrelse:** 1W eller to 'bytes'.
    - **Utføringstid:** Én sykel per instruksjon.
    - **Arbeid gjort:** Mindre arbeid per instruksjon.
    - **Intet mikroprogram:** Utfører heller instruksjonen direkte.
    - **Instruksjoner per program:** Mange. Enkle og primitive.
  - **CISC** - (Complex) Instruction Set Computing)
    - **Instruksjonsstørrelse:** Mange W.
    - **Utføringstid:** Gjennomsnittlig antal sykler per instruksjon er 2 til 15.
    - **Arbeid gjort:** Mye arbeid per instruksjon. Komplekse instruksjoner.
    - **Instruksjoner per program:** Førre enn RISC. Skyldes større og mer komplekse instruksjoner.
  
- **Mikroarchitecture**
  - **Von Neumann:**
    - *Instruksjoner* og *data* ligger i samme minnenhet.
    - Bruker samme BUS for instruksjoner og data. Simpelt design - færre komponenter. 
      - Beregninger skjer **sekvensielt** pga. dette.
    - Kan endre sin egen programkode.
    - Komponentene er hver for seg.
      - 'Arbeidslager' som inneholder *data* og *instruksjoner* på **binær** form.
      - ALU som kunne utføre en del matematiske og logiske operasjoner.
      - Kontrollenhet(CPU) som tolker instruksjoner i minnet og sørger for utførelse.
      - I/O-enheter som sørger for kommunikasjon mellom bruker og kontrollenhet (CPU).
    - Utfordringen i dag er dataoverføring mellom minne og CPU. For stor hastighetsforskjell.

  - **Harward:**
    - Separert BUS for *instruksjoner* og *data*. Kan aksessere både *data* og *instruksjoner* i parallell.
    - Komponenter er hver for seg i parallell.
      - CPU
      - Instruksjonsminne
      - Dataminne

  - **Hardware Components**
    - Valgfritt å ha med.
    - Eksempler:
      - **RAM** (Random Access Memory)
      - **ROM** (Read-Only Memory)
      - **I/O**-porter.

  **LES MER PÅ DETTE**
  - Mikro**prosessor**
    - ISA + Mikroarkitekturer
  
  - Mikro**kontroller**
    - ISA + Mikroarkitektur + Harware Components

  - **MIR** (Micro Instruction Register)
    - **Addr** - (Address) peker på neste mikroinstruksjon.
    - **J** - (Jam) sier ifra om ALU har flagget neste mikrinstruksjon eller om det kommer et betinget hopp.
    - **ALU** - (Aritmethic Logic Unit) bestemmer hvilken funksjon ALU skal gjennomføre.
    - **C** - (C-BUS) inneholder adressen til C-BUSen => Adressen til registeret det skal skrives til.
    - **Mem** - (Memory) - sier ifra om det skal gjøres noe med minnet.

- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
- **** - ()
