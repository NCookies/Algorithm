def baseB_to_decimal(N: str, B: int) -> int:
    result = 0
    for ch in N:
        if '0' <= ch <= '9':
            value = ord(ch) - ord('0')
        else:
            value = ord(ch) - ord('A') + 10
        result = result * B + value
    return result

if __name__ == "__main__":
    N, B = input().split()
    B = int(B)
    print(baseB_to_decimal(N, B))
