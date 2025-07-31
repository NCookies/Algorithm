def selection_sort(array):
    n = len(array)

    for i in range(0, n):
        min_index = i
        for j in range(i, n):
            if array[j] < array[min_index]:
                min_index = j
        array[i], array[min_index] = array[min_index], array[i]

arr = [5, 4, 3, 2, 1]
selection_sort(arr)
print(arr)