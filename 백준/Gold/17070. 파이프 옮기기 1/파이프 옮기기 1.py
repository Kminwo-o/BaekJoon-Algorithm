import sys

input = sys.stdin.readline

def dfs(x, y, now):
    global cnt
    if x == N - 1 and y == N - 1:
        cnt += 1
        return

    if x + 1 < N and y + 1 < N:
        if arr[x + 1][y + 1] == 0 and arr[x][y + 1] == 0 and arr[x + 1][y] == 0:
            dfs(x + 1, y + 1, 2)

    if now == 0 or now == 2:
        if y + 1 < N and arr[x][y + 1] == 0:
            dfs(x, y + 1, 0)

    if now == 1 or now == 2:
        if x + 1 < N and arr[x + 1][y] == 0:
            dfs(x + 1, y, 1)

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
cnt = 0

dfs(0, 1, 0)

print(cnt)