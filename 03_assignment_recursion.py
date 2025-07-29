def get_count_of_ways_to_target(array, target):
    results = plus_or_minus(array, 0, 0)
    count = results.count(target)

    return count

def plus_or_minus(array, cur_index, cur_sum):
    if cur_index == len(array):
        return [cur_sum]

    plus = plus_or_minus(array, cur_index + 1, cur_sum + array[cur_index])
    minus = plus_or_minus(array, cur_index + 1, cur_sum - array[cur_index])

    return plus + minus

get_count_of_ways_to_target([1, 1, 1, 1, 1], 3)
