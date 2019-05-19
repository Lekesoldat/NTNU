# Image describing my experience with the course:
<img src="./img/eclipseMeme.png">

Funniest subject this semester. Fuck Eclipse.


----
#### Table of Contents  
[Theory from Wiki](#Theory)

[Exams](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exams)

- [Kont 2018](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exams/Kont2018)
- [Kont 2017](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exams/Kont2017)
- [2017](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exams/2017)
- [2016](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exams/2016)

[Exercises](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises)

- [Exercise 1](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O1)
  - Account
  - Digit
  - LineEditor
  - Location
  - UpOrDownCounter
- [Exercise 2](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O2)
  - Account
  - Person
  - Vehicle
- [Exercise 3](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O3)
  - Card
  - Nim
  - RPNCalc
- [Exercise 4](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O4/app)
  - An app for sleep tracking.
- [Exercise 5](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O5)
  - Card
  - Partner
  - Person
  - StopWatch
  - Twitter
- [Exercise 6](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O6)
  - Card
  - Twitter
  - BinaryComputingIterator
  - Named
  - StringMergeIterator
- [Exercise 7](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O7/app)
  - An app for sleep tracking continued.
- [Exercise 8](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O8)
  - Delegation
    - The Office
    - Logger

  - Observable
    - Highscorelist
    - Stocklistener
- [Exercise 9](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O9)
  - Inheritance
    - Train

  - Observable
    - ObservableList
- [Exercise 10](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/O10)
  - SleepEntryTest
  - WriteToFileTest

- [Lambda exercise from wiki](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Exercises/Lambda)


[Private learning](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Private)

- [[Unfinished] Expense Tracker](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Private/ExpenseTracker/src/main/java/ExpenseTracker)

- [[INTERMEDIATE] Self made linked list](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Private/LinkedListWithIterator/src)

- [[Exam practice] Legesystem](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Private/Legesystem/src/main/java/Legesystem)

- [Random files](https://github.com/Lekesoldat/NTNU/tree/master/TDT4100%20-%20Objektorientert%20Programmering/Private/src)
  - Practising Streams
  - Practising I/O


-----

## Theory

### Innkapsling og validering
 
1. a) Hva er forskjellen på public, private og protected?
<pre>
            │ Class │ Package │ Subclass │ Subclass │ World
            │       │         │(same pkg)│(diff pkg)│ 
────────────┼───────┼─────────┼──────────┼──────────┼────────
public      │   +   │    +    │    +     │     +    │   +     
────────────┼───────┼─────────┼──────────┼──────────┼────────
protected   │   +   │    +    │    +     │     +    │         
────────────┼───────┼─────────┼──────────┼──────────┼────────
no modifier │   +   │    +    │    +     │          │    
────────────┼───────┼─────────┼──────────┼──────────┼────────
private     │   +   │         │          │          │    

 + : accessible         blank : not accessible
</pre>

1. b) Hva bør i utgangspunktet alle variablene dine være deklarert som?
<pre>
Private.
</pre>

2. Hvilke to metoder er vanlig å ha for variabler i Java?
<pre>
Getters og setters.
</pre>

3. Hva er forskjellen på ugyldig tilstand og ugyldig argument?
<pre>
Ugyldig tilstand, - man setter en variabel til noe som ikke gir mening.
Ugyldig argument, - metoden kalles med et argument som ikke er tiltenkt metoden.
</pre>

4. Hva er meningen med innkapsling og validering?
<pre>
Forhindre ugyldig tilstand og feil ved runtime.
</pre>

5. Trenger man å validere argumenter som tas inn i konstruktøren?
<pre>Ikke et krav, men man burde.</pre>


--- 

### Typer

```java
List<String> liste = new ArrayList<String>();
```
1. a) Hva er sammenhengen med typen deklarert på venstre-side og typen deklarert på høyre-side? 
<pre>
List er et interface som ArrayList arver fra.
</pre>

1. b) Hvordan påvirker det videre programmering at det står <String>?
<pre>
Lsiten vil kun kunne inneholde objekter av typen String.
</pre>


No more theory.