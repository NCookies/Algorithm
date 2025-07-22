def find_max_plus_or_multiply(array):
    sum = 0
    for number in array:
        if number <= 1 or sum <= 1:
            sum += number
        else:
            sum *= number

    return sum
