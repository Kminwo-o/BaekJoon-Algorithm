import sys
from collections import deque

input = sys.stdin.readline

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(r, c):
    visited = [[0] * M for _ in range(N)]
    visited[r][c] = 1
    queue = deque([(r, c)])

    while queue:
        x, y = queue.popleft()

        for dr, dc in d:
            nx = x + dr
            ny = y + dc

            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] >= 1:
                    arr[nx][ny] += 1
                    visited[nx][ny] = 1
                else:
                    if not visited[nx][ny]:
                        queue.append((nx, ny))
                        visited[nx][ny] = 1


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
time = 0


def empty(ars):
    for i in range(N):
        for j in range(M):
            if ars[i][j] != 0:
                return False
    return True


while True:
    if empty(arr):
        break

    time += 1
    bfs(0, 0)

    for i in range(N):
        for j in range(M):
            if arr[i][j] >= 3:
                arr[i][j] = 0
            elif arr[i][j] == 2:
                arr[i][j] = 1

print(time)