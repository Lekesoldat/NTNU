import os
hemmelig_ord = input("Skriv inn et hemmelig ord! \n> ").lower()
antall_liv = int(input("Hvor mange liv skal spilleren ha? \n> "))

# Linje brukes for å få frem _ _ _ _ for alle bokstavene i ordet. 
linje = []
for b in hemmelig_ord:
    linje.append('_')

bokstaver = []
os.system('cls' if os.name == 'nt' else 'clear')
while True:
    # Legger til litt space for hver kjøring 
    print()

    # Sjekker om du har fler liv
    if antall_liv == 0:
        print("\033[1;31m" + "Ikke fler liv igjen." + "\033[0;0m")
        print("Ordet var " + hemmelig_ord.upper() + "!")
        break

    # Printer linjen med bokstaver
    for i in range(len(linje)):
        
        # Ønsker å printe inline, bruker derfor end ""
        print(linje[i], sep='', end="")

    gjettetBokstav = input("\nGjett en bokstav! \n> ").lower()

    # Sjekker om du har gjettet bokstaven tidligere
    if gjettetBokstav in bokstaver:
        print("Denne har du allerede gjettet")
    
    else :
        # Sjekker om bokstaven er i ordet
        if gjettetBokstav in hemmelig_ord:
            bokstaver.append(gjettetBokstav)
            
            # Går igjennom det hemmelige ordet og legger til bokstavene i linjen som printes
            for i in range(len(hemmelig_ord)):
                if gjettetBokstav == hemmelig_ord[i]:
                    linje[i] = gjettetBokstav

            # Sjekker om hele ordet matcher
            if linje == list(hemmelig_ord):
                print("\033[0;32m" + "\nDu klarte det!" + "\033[0;0m")
                print("Ordet var: " + hemmelig_ord.upper() + "!")
                break

        else:
            antall_liv -= 1
            print("\033[1;36m" + "Feil!" + "\033[0;0m" + "\nDu har " + str(antall_liv) + " liv igjen.")





    