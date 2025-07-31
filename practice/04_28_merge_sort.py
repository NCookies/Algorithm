# O(nlogn)
def merge_sort(array):
    if len(array) <= 1:
        return array

    mid = len(array) // 2
    left_arr = merge_sort(array[:mid])
    right_arr = merge_sort(array[mid:])

    return merge(left_arr, right_arr)

def merge(left_arr, right_arr):
    result = []
    left_index = 0
    right_index = 0

    while left_index < len(left_arr) and right_index < len(right_arr):
        if left_arr[left_index] < right_arr[right_index]:
            result.append(left_arr[left_index])
            left_index += 1
        else:
            result.append(right_arr[right_index])
            right_index += 1

    while left_index < len(left_arr):
        result.append(left_arr[left_index])
        left_index += 1

    while right_index < len(right_arr):
        result.append(right_arr[right_index])
        right_index += 1

    return result

arr = [5, 4, 3, 2, 1]
sorted_list = merge_sort(arr)
print(sorted_list)