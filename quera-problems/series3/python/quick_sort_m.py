hoare_counts = lomuto_counts = 0

def lomuto_partition(arr, low, high):
    pivot = arr[high]
    i = (low - 1)
    for j in range(low, high):
        if (arr[j] <= pivot):
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return (i + 1)


def hoare_partition(arr, low, high):
    pivot = arr[low]
    i = low - 1
    j = high + 1

    while (True):
        i += 1
        while (arr[i] < pivot):
            i += 1
        j -= 1
        while (arr[j] > pivot):
            j -= 1
        if (i < j):
            arr[i], arr[j] = arr[j], arr[i]
        else:
            return j


def hoare_quick_sort(array, start, end):
    global hoare_counts
    hoare_counts += 1
    if (start < end):
        p = hoare_partition(array, start, end)
        hoare_quick_sort(array, start, p)
        hoare_quick_sort(array, p + 1, end)


def lomuto_quick_sort(array, start, end):
    global lomuto_counts
    lomuto_counts += 1
    if (start < end):
        p = lomuto_partition(array, start, end)
        lomuto_quick_sort(array, start, p - 1)
        lomuto_quick_sort(array, p + 1, end)


test_arrays_lomuto = []
test_arrays_hoare = []
tests_quantity = int(input())
for i in range(0, tests_quantity):
    test_array_length = int(input())
    test_array_lomuto = []
    test_array_hoare = []
    for j in range(0, test_array_length):
        input_value = int(input())
        test_array_lomuto.append(input_value)
        test_array_hoare.append(input_value)
    test_arrays_lomuto.append(test_array_lomuto)
    test_arrays_hoare.append(test_array_hoare)


def choose_efficient(lomuto_test, hoare_test):
    lomuto_quick_sort(lomuto_test, 0, len(lomuto_test) - 1)
    hoare_quick_sort(hoare_test, 0, len(hoare_test) - 1)
    if lomuto_counts > hoare_counts:
        return "HR"
    elif lomuto_counts < hoare_counts:
        return "LMT"
    else:
        return "TIE"


for i in range(0, tests_quantity):
    lomuto_counts = 0
    hoare_counts = 0
    print(choose_efficient(test_arrays_lomuto[i], test_arrays_hoare[i]))
