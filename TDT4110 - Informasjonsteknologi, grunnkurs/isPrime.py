def divisable(a, b):
  return a % b == 0

def isPrime(a):
  for b in range(2, a):
    if divisable(a, b):
      return False

  return True

print(isPrime(15))  # False
print(isPrime(11))  # True
