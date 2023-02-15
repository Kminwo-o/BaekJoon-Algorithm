import sys
input = sys.stdin.readline

N, K = map(int, input().split())
coin = [0] * N
cnt = 0

for i in range(N):
    coin[i] = int(input())

for i in coin[::-1]:
    if K // i > 0:
        cnt += K // i
        K %= i
        if K == 0:
            break

print(cnt)