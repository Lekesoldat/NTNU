# Lager en funksjon
def summerRekke(base, n):
    # Tar vare på summen
    sum = 0

    # Eksponent
    i = 0

    # Kjører fra og med 0, til og med n ganger
    while i <= n:
        # Oppdaterer sum
        sum += base**i

        # Øker eksponenten med 1 per kjøring
        i += 1

    print(sum)

summerRekke(0.5, 4)