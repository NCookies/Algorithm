import math

def is_prime(number):
    for i in range(2, int(math.sqrt(number)) + 1):
        if number % i == 0:
            return False
    return True

def print_prime_number(number):
    prime_numbers = [ 2 ]
    for i in range(3, number + 1):
        if is_prime(i):
            prime_numbers.append(i)
        i += 2

    print(prime_numbers)

def print_prime_number_enhanced(number):
    prime_numbers = [ 2 ]

    for i in range(3, number + 1):
        for j in prime_numbers:
            if j <= math.sqrt(i) and i % j == 0:
                break
        else:
            prime_numbers.append(i)

    print(prime_numbers)

print_prime_number(100)
print_prime_number_enhanced(100)