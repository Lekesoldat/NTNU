# Image describing my experience with the course:

<div style="text-align: center;">
  <img src="./img/plankekjoring.jpg">
</div>

Used to be fairly easy, - as we say in norwegian: 'Plankekjøring'.  
Did not take this course at NTNU, but did some of the tasks as I was asked to help. Below you will find a cheat sheet I made for the subject.

---

# ITGK - Python Cheat Sheet

Med forbehold om feil.

![Cheat Sheet Logo](https://i.imgur.com/Per55Ez.png)

# Variabler

Bruker variabler for å midlertidig lagre data i minnet på datamaskinen.

```python
price = 10
rating = 4.9
course_name: 'Informasjonsteknologi, grunnkurs'
is_ready_for_exam: True
```

**I eksempelet over:**  
`price` er en _`integer`_ (heltall).  
`rating` er en _`float`_ (desimaltall).  
`course_name` er en _`string`_ er (sekvens med tegn).  
`is_ready_for_exam` er en _`boolean`_ (sannhetsverdi som enten er **True** eller **False**).

# Kommentarer

Vi bruker kommentarer for å skrive små notater i koden. God kode har gjerne få kommentarer og kommentarene som er der er gjerne for å oppklare _hvorfor_ noe gjøres og evt. antakelser, - ikke hvordan koden fungerer. Hva som skjer i koden kommer gjerne frem av gode variabel og funksjonsnavn.

```python
# Dette er en kommentar. Kode som er 'kommentert ut' vil ikke kjøre.

"""
Dette
er en
kommentar over flere
linjer.
"""
```

# Input

Når vi koder er det ofte interessant å få tak i 'input' fra tastaturet. Python har en innebygd funksjon, `input()`, for det.

Merk at teksten inni `input(...)` er den som vil vises til brukeren i terminalen.

```python
my_name: input("Navn: ")
```

**NB!**  
All `input()` tolkes som en `string`. Om du ønsker et tall, så må du konvertere. Dette kan gjøres med den innebygde funksjonen `int()`.

```python
birth_year: int(input("Årstall: "))
```

# Strings

Vi definerer strenger ved bruk av `' '` enkle eller `" "` doble anførselstegn.

I `Python` kan vi jobbe med strenger på samme måte som vi jobber med et array.

```python
course = "Informasjonsteknologi, grunnkurs"
course[0] # returnerer det første tegnet -> 'I'
course[1] # returnerer det andre tegnet -> 'n'
course[-1] # returnerer det bakerste tegnet -> 's'
course[-2] # returnerer det nest bakerste tegnet -> 'r'
```

Med samme notasjon kan vi også `slice` (dele opp) en streng.

```python
course[1:5] # Returnerer 'nfor'
```

Uttrykket over returnerer alle tegnene **fra og med** startposisjon `1`, **til (men ikke med)** sluttposisjon `5`.

Merk:  
Om vi lar være å oppgi `startindeks`, så antas `startindeks = 0`.
Om vi lar være å oppgi `sluttindeks`, så antas `sluttindegs = lengden av strengen`.

```python
course[:5] # Returnerer 'Infor'
course[5:] # Returnerer 'masjonsteknologi, grunnkurs'
```

Vi kan formattere strenger for å dynamisk sette inn verdier i dem.

```python
name = "Magnus"
message = "Jeg heter {}".format(name)
print(message) # "Jeg heter Magnus"
```

Vi har også en del metoder for å behandle strenger:

```python
message.upper() # GJØR ALT TIL UPPERCASE
message.lower() # gjør alt til lowercase
message.title() # Stor Forbokstav I Alle Ord
message.find("M") # returnerer indeksen til første forekomst av bokstaven "M".
message.replace("m", "q") # Erstatter alle "m" med "q".
```

For å sjekke om en streng inneholder et ord, et tegn eller en sub-streng:

```python
contains_teknologi = "teknologi" in course # Returnerer True
```

# Aritmetiske operasjoner

```python
5 + 2 = 7   # +
5 - 2 = 3   # -
5 * 2 = 10  # *
5 / 2 = 2.5 # / returnerer float (desimaltall)
5 // 2 = 2  # // returnerer et heltall. Runder ned.
5 % 2 = 1   # % returnerer resten ved divisjon.
5 ** 2 = 25 # ** eksponent.
```

# Utvidede tilordninger

```python
x = x + 1
# kan skrivers som
x += 1

# Fungerer for + - * / og //
```

# If-statements

Slår inn om noe er sant eller ikke.

```python
if is_hot:
  print(“hot day”)
elif is_cold:
  print(“cold day”)
else:
  print(“beautiful day”)
```

## Logiske operatorer

```python
if has_high_income and has_good_credit:
  print("Han her er rik!")
if has_high_income or has_good_credit:
  print("Han her er enten rik, eller har god kreditt.")

is_day = True
is_night = not is_day
```

## Sammenligning

```python
a > b
a >= b # større enn eller lik
a < b
a <= b
a == b # lik
a != b # ikke lik
```

# Løkker

Løkker helt til et visst kriterie er oppnådd.

## While-løkke

En while-løkke kjører til et viss krav er møtt.

```python
i = 1
while i < 5:
    print(i)  # Kommer til å printe først 1, så 2, så 3, så 4.
    i += 1    # Øker 'i' slik at while-løkken stopper til slutt.
```

## For-løkke

En for-løkke kjører x antall ganger.

```python
liste = ["ball", "båt", "pc", "iphone", "hund"]
for i in (range(len(liste))):
    print(liste[i])
```

```python
for i in range(1, 5):
    print(i) # Printer 1, 2, 3, 4
```

`range()` defineres slik:

```python
range(start, stop, step)
```

Den går fra og meg start, til stop.  
Start er valgri, om den ikke oppgis antas 0.  
Step er valgfri, men den angir hvor mange steg den tar om gangen.

```python
range(5) -> 0, 1, 2, 3, 4
range(1, 5) -> 1, 2, 3, 4
range(1, 10, 2) -> 1, 3, 5, 7, 9
```

I stedet for å bruke indekser for å hente ut elementene når vi går igjennom en liste, så er det mulig å gjøre slik:

```python
liste = ["ball", "båt", "pc", "iphone", "hund"]
for element in liste:
    print(element) # Printer ball, båt, pc, iphone, hund
```

# Lister

En liste er en måte å holde på verdier. Verdiene kan være hva som helst, - det kan for eksempel være tall, strenger og variabler.

```python
minBil = "Audi R8"
biler_og_tall = [2, "Toyota", "Suzuki", minBil, 11]
```

Bruk av lister:

```python
biler_og_tall[0] # returnerer første element -> 2
biler_og_tall[1] # returnerer andre element -> "Toyota"

biler_og_tall[-1] # returnerer siste element -> 11
biler_og_tall[-2] # returnerer nest siste element -> minBil -> "Audi R8"

biler_og_tall.append(6) # legger til 6 bakerst
biler_og_tall.insert(0, 6) # legger til 6 på plass 0

biler_og_tall.remove(6) # fjerner første forekomst av 6
biler_og_tall.pop() # fjerner og returnerer bakerste element -> 11

biler_og_tall.clear() # tømmer listen
biler_og_tall.index("Audi R8") # returnerer indeksen til "Audi R8" -> 2

biler_og_tall.sort() # sorterer listen
biler_og_tall.reverse() # rreverserer listen
biler_og_tall.copy() # returnerer en kopi av listen
```

# Tupler

Det er litt som en read-only-liste. Vi lagrer verdier, men så fort vi har lagret verdiene, så kan de ikke endres.

Vi kan "unpacke" både lister og tupler som vist under. Merk at det må være like mange variabler som elementer i listen for at det skal fungere.

```python
koordinater = (1, 2, 3)
x, y, z = koordinater # x = 1, y = 2, z = 3
```

# Dictionaries

Brukes for å lagre par med nøkler/verdier.

```python
customer = {
  "name": "Magnus",
  "age": 21,
  "is_verified": True
}
```

Vi bruker både strenger og tall som 'keys', og de bør være unike.

Bruk av dictionaries:

```python
customer["name"] # returnerer "Magnus"
customer["gender"] # gir feilmelding da det ikke finnes en key == "gender".
customer["name"] = "Holtet" # Overskriver verdien som allerede ligger der.
```

Hvordan gå igjennom et dictionary med en loop:

```python
for key in customer:
  print(key) # Printer "name", "age", "is_verified"

  # Kan da hente ut verdiene
  print(customer[key]) # Printer "Magnus", 21, True
```

Kan også gjøres slik:

```python
for key, value in customer.items():
  print(key)    # Printer "name", "age", "is_verified"
  print(value)  # Printer "Magnus", 21, True
```

# Funksjoner

Vi lager funksjoner for å dele koden vår opp i mindre biter. Det er dårlig praksis å skrive samme kodebiter om igjen og om igjen, så da er det bedre å separere det i funksjoner man kan kjøre. En funksjon gjør ikke noe, før man 'kaller' (kjører) den.

```python
# DEFinerer funksjonen
def si_hei():
  print("Hei!")

# Kaller funksjonen
si_hei() # Printer "Hei!"
```

**En funksjon kan få input, kalt argumenter:**

```python
def hils_paa_person(navn):
  print("Hallo, " + navn + "!")

hils_paa_person("Magnus") # Printer "Hallo, Magnus!"

# En funksjon kan ha flere argumenter
def pluss(tall1, tall2):
  print(tall1 + tall2)

pluss(2, 5) # Printer 7
```

**En funksjon kan også _returnere_ en verdi som vi kan bruke videre:**

```python
def minus(tall1, tall2):
  return tall1 - tall2

svar = minus(5, 2)
print(svar) # Printer 3
```

# Filbehandling

```python
# Ved å bruke "with open ... as ... slipper du å tenke på å 'close()' filen til slutt.
with open("filnavn", "mode") as doc:
  for line in doc:
    print(line) # Printer alle linjer i filen

with open("minFil.txt", "r")
```

| Mode | Hva den gjør                                                                 |
| :--: | ---------------------------------------------------------------------------- |
|  r   | Read-only. Leser fra start. Er standard i `open()`-metoden.                  |
|  rb  | Åpner for lesing binært.                                                     |
|  r+  | Åpner for lesing og skrving, setter markøren på starten av filen.            |
|  w   | Åpner for skriving. Overskriver filen eller oppretter ny om den ikke finnes. |
|  wb  | Åpner for skriving binært.                                                   |
|  w+  | Åpner for skriving og lesing.                                                |
|  a   | Åpner for appending, setter markør på slutten av filen                       |

# Moduler

En modul er en fil med Python-kode. Vi pleier å bruke moduler for å splitte opp programmene våre ytterligere, og i ITGK lager vi ingen sånne selv. Vi bruker derimot noen standard-moduler/biblioteker. Eksempler på dette er `random` og `math`.

```python
import random
tilfeldig_tall = random.random() # Lagrer et tilfeldig desimaltall mellom 0 og 1 i variabelen.
annet_tall = random.random(1, 6) # Lagrer et tilfeldig tall mellom 1 og 6 i variabelen.

studenter = ["Magnus", "Snorre", "Eirik", "Synne"]
leder = random.choice(studenter) # Velger et tilfeldig element i listen.
```

```python
import math
print("Verdien av π er: ", math.pi)
```
