import sys
input = sys.stdin.readline

N,K = map(int, input().split())
dp = [[0]*(K+1) for _ in range(N+1)]

bag = []
for i in range(N):
    bag.append(list(map(int, input().split())))

for i in range(1, N+1):
    for j in range(K+1):
        weight = bag[i-1][0]
        value = bag[i-1][1]

        if j < weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight] + value)

print(dp[N][K])