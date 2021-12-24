from collections import Counter

def solve(arr1, arr2):
    res = []
    f = Counter(arr1)

    for e in arr2:
        res.extend([e] * f[e])
        f[e] = 0
    rem = list(sorted(filter(lambda x: f[x] != 0, f.keys())))

    for e in rem:
        res.extend([e] * f[e])

    return res


if __name__ == "__main__":

    arr_size = list(map(int, input().strip().split()))
    arr1 = list(map(int, input().strip().split()))
    arr2 = list(map(int, input().strip().split()))

    print(*solve(arr1, arr2))
