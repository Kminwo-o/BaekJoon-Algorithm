import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int,input().split()))
dp = [1 for _ in range(N)]
ans = []

for i in range(N):
    for j in range(i+1):
        if lst[i] > lst[j]:
            dp[i] = max(dp[i], dp[j]+1)

best_cnt = max(dp)
print(best_cnt)

for i in range(N-1,-1,-1):
    if dp[i] == best_cnt:
        ans.append(lst[i])
        best_cnt -= 1

ans.sort()

print(*ans)