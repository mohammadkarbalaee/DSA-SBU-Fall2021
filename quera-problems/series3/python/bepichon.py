def partition(array, begin, end):
    pivot_idx = begin
    for i in range(begin + 1, end + 1):
        if array[i] <= array[begin]:
            pivot_idx += 1
            array[i], array[pivot_idx] = array[pivot_idx], array[i]
    array[pivot_idx], array[begin] = array[begin], array[pivot_idx]
    return pivot_idx


def quick_sort_recursion(array, begin, end):
    if begin >= end:
        return
    pivot_idx = partition(array, begin, end)
    quick_sort_recursion(array, begin, pivot_idx - 1)
    quick_sort_recursion(array, pivot_idx + 1, end)


def quick_sort(array, begin=0, end=None):
    if end is None:
        end = len(array) - 1


    return quick_sort_recursion(array, begin, end)


screw_ascii_arr = []
screw_char_arr = []
vertebrae_ascii_arr = []
vertebrae_char_arr = []

n = int(input())
for i in range(0, n):
    char_screw = input()
    screw_char_arr.append(char_screw)

    ascii_screw = ord(char_screw)
    screw_ascii_arr.append(ascii_screw)

for i in range(0, n):
    char_vertebrae = input()
    vertebrae_char_arr.append(char_vertebrae)

    ascii_vertebrae = ord(char_vertebrae)
    vertebrae_ascii_arr.append(ascii_vertebrae)

quick_sort(screw_char_arr, 0, n-1)
print(screw_char_arr)