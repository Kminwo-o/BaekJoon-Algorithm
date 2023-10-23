import sys
input = sys.stdin.readline

def binary_search(x, arr, length):
    left = 0
    right = length

    while (left < right):
        mid = (left + right) // 2
        if (arr[mid] < x):
            left = mid + 1
        else:
            right = mid

    return left

N = int(input())
lst = list(map(int, input().split()))
answer = [0] * (N+1)

idx = 0

for i in range(N):
    num = lst[i]
    if (answer[idx] < num):
        idx += 1
        answer[idx] = num
    else:
        lowbound = binary_search(num, answer, idx)
        answer[lowbound] = num

print(idx)