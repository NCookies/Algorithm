finding_numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

def is_existing_binary_search(array, target):
    low = 0
    high = len(array) - 1
    mid = (low + high) // 2

    while low <= high:
        if array[mid] == target:
            print("Found target")
            return True
        elif array[mid] < target:
            low = mid + 1
        else:
            high = mid - 1

        mid = (low + high) // 2

    print("Not found")
    return False

is_existing_binary_search(finding_numbers, 10)
is_existing_binary_search(finding_numbers, -1)
is_existing_binary_search(finding_numbers, 18)