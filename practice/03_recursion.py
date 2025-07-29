def factorial(n):
    if n == 1:
        return 1

    return n * factorial(n - 1)

def is_palindrome(string):
    if string[0] != string[-1]:
        return False
    if len(string) == 1:
        return True

    return is_palindrome(string[1:-1])

print(factorial(5))

print(is_palindrome("토마토"))
print(is_palindrome("테스트"))
print(is_palindrome("abcba"))
