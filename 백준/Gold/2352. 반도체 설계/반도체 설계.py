import sys
input = sys.stdin.readline

def binary_search(num):
    left = 0
    right = len(dp)-1

    while left <= right:
        mid = (left + right) // 2

        if dp[mid] < num:
            left = mid + 1
        else:
            right = mid - 1
    
    return left

N = int(input())
port_lst = list(map(int, input().split()))
dp = [port_lst[0]]

for i in range(1, N):
    if port_lst[i] > dp[-1]:
        dp.append(port_lst[i])
    else:
        idx = binary_search(port_lst[i])
        dp[idx] = port_lst[i]

print(len(dp))