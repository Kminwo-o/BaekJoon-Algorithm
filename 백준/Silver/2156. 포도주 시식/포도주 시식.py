N = int(input())
grape = []
dp = [0] * 10001
for _ in range(N):
    grape.append(int(input()))

dp[0] = grape[0]
if N == 1:
    print(sum(grape))
else:
    dp[1] = grape[0] + grape[1]
    if N == 2:
        print(sum(grape))
        
    else:
        dp[2] = max(grape[2]+grape[0], grape[1] + grape[2], grape[0] + grape[1])
        for i in range(3, N):
            dp[i] = max(dp[i-2]+grape[i], grape[i]+grape[i-1]+dp[i-3], dp[i-1])

        print(max(dp))