def partition(array, start, end):
    x = array[end]
    i = start - 1
    for j in range(start, end-1) :
        if array[j] <= x :
            i = i + 1
            array[j] , array[i] = array[i], array[j]
    array[end], array[i+1] = array[i+1], array[end]
    return i+1

def quick_sort(array, start, end) :
    if start < end :
        q = partition(array, start, end)
        quick_sort(array, start, q-1)
        quick_sort(array, q+1, end)
        print(array)


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

#print(screw)

for i in range(0, n):
    char_vertebrae = input()
    vertebrae_char_arr.append(char_vertebrae)

    ascii_vertebrae = ord(char_vertebrae)
    vertebrae_ascii_arr.append(ascii_vertebrae)

#print(vertebrae)
quick_sort(screw_char_arr,0,n-1)
#print(screw_char_arr)
