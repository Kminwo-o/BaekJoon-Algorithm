import sys

input = sys.stdin.readline

N, L = map(int, input().split())
now = 0
answer = 0

for _ in range(N):
    d, r, g = map(int, input().split())

    answer += (d - now)
    now = d
    if answer % (r + g) <= r:
        answer += (r - (answer % (r + g)))

answer += (L - now)
print(answer)