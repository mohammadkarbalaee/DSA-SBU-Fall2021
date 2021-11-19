def partition(start, end, array):
    pivot_index = start
    pivot = array[pivot_index]
    while start < end:
        while start < len(array) and array[start] <= pivot:
            start += 1
        while array[end] > pivot:
            end -= 1
        if (start < end):
            array[start], array[end] = array[end], array[start]
    array[end], array[pivot_index] = array[pivot_index], array[end]
    return end


def quick_sort(start, end, array1, array2):
    if (start < end):
        p = partition(start, end, array2)
        quick_sort(start, p - 1, array1, array2)
        quick_sort(p + 1, end, array1, array2)


n = int(input())
screw_char_arr = (input()).split()
vertebrae_char_arr = (input()).split()


quick_sort(0, n - 1, screw_char_arr, vertebrae_char_arr)
quick_sort(0, n - 1, vertebrae_char_arr, screw_char_arr)
print(*screw_char_arr, sep = " ")
print(*vertebrae_char_arr, sep = " ")