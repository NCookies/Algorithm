# 항상 O(n^2)의 성능을 보이는 버블 정렬과 선택 정렬과 다르게 값이 어느 정도 정렬되어 있다면 그만큼 성능이 좋아짐
def insert_sort(array):
    for i in range(1, len(array)):
        for j in range(i, 0, -1):
            if array[j] < array[j - 1]:
                array[j], array[j - 1] = array[j - 1], array[j]
            else:
                break

arr = [5, 4, 3, 2, 1]
insert_sort(arr)
print(arr)
