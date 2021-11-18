array = list(map(int, input().split()))
array_length = array[0]
special_length = array[1]
array.pop(0)
array.pop(0)
degree = 0
for i in range(0, array_length - special_length):
    is_found = False
    for j in range(i,array_length):
        bigger_counter = 0
        if array[j] > array[i]:
            bigger_counter += 1
            for k in range(j + 1, array_length):
                if array[k] > array[i]:
                    bigger_counter += 1
                    if bigger_counter == special_length:
                        if k == array_length - 1:
                            degree += array[i]
                            break
                        else:
                            if array[k + 1] <= array[i]:
                                degree += array[i]
                                break
                else:
                    break
        if bigger_counter == special_length:
            is_found = True
            break

    if not is_found:
        for j in range(i, 0):
            bigger_counter = 0
            if array[j] > array[i]:
                bigger_counter += 1
                for k in range(j - 1, -1):
                    if array[k] > array[i]:
                        bigger_counter += 1
                        if bigger_counter == special_length:
                            if k == 0:
                                degree += array[i]
                                break
                            else:
                                if array[k - 1] <= array[i]:
                                    degree += array[i]
                                    break
                    else:
                        break
            if bigger_counter == special_length:
                break

print(degree)
