from collections import Counter


def speacial_sort(first_array, second_array):
    sorted_array = []
    f = Counter(first_array)
    for e in second_array:
        sorted_array.extend([e] * f[e])
        f[e] = 0
    remaining = list(sorted(filter(lambda x: f[x] != 0, f.keys())))
    for e in remaining:
        sorted_array.extend([e] * f[e])
    return sorted_array


arr_size = list(map(int, input().strip().split()))
first_array = list(map(int, input().strip().split()))
second_array = list(map(int, input().strip().split()))

print(*speacial_sort(first_array, second_array))
