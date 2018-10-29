def fib(k):
    # Starter med de to første tallene
    rekke = [0, 1]

    # Plusser sammen de to siste tallene som er i listen og legger til
    for i in range(2, k):
        rekke.append(rekke[i - 1] + rekke[i - 2])

    # Viser frem rekken
    print(rekke)
    
    # Viser frem det k'te tallet (trekker fra 1 fordi den starter å telle med null)
    return rekke[k-1]

print(fib(5)) # --> 3