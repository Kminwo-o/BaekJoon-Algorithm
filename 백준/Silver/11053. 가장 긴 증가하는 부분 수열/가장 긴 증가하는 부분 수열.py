import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int,input().split()))
dp = [0 for _ in range(N+1)]

for i in range(N):
    for j in range(i+1):
        if lst[i] > lst[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp)+1)