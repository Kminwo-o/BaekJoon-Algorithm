import sys
input = sys.stdin.readline

def binary_search(target):
    s, e = 0, len(lst)-1
    while s<=e:
        mid = (s+e)//2
        if target <= lst[mid]:
            e = mid - 1
        elif target > lst[mid]:
            s = mid + 1
    return s

INF = int(1e9)
n = int(input())
arr = list(map(int, input().split()))
lst = [-INF]
dp = [1]*(n+1)

for i in range(n):
    if lst[-1] < arr[i]:
        lst.append(arr[i])
        dp[i] = len(lst)-1
    else:
        dp[i] = binary_search(arr[i])
        lst[dp[i]] = arr[i]

N = max(dp)     # 최대 수열길이
print(N)
ans = []
for j in range(n-1, -1, -1):
    if dp[j] == N:
        ans.append(arr[j])
        N -= 1

print(*ans[::-1])