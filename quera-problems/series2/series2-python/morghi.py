number_of_input = int(input())
length_of_ties = []

for i in range(number_of_input):
    length_of_ties.append(int(input()))

for i in range(number_of_input - 1):
    leastIndex = i
    for i in range(number_of_input):
        j = i
        if length_of_ties[j] < length_of_ties[leastIndex]:
            leastIndex = j
    x = length_of_ties[leastIndex]
    length_of_ties[leastIndex] = length_of_ties[i]
    length_of_ties[i] = x

    result = 0
    for i in range(number_of_input):
        result += abs(length_of_ties[i] - (i + 1))
print(int(result))
