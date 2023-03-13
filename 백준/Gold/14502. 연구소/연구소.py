import sys
from collections import deque

sys.stdin.readline
input = sys.stdin.readline

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def back(cnt):
    global best_safe_area
    if cnt == 3:
        safe_area = bfs()

        if safe_area > best_safe_area:
            best_safe_area = safe_area

        return

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                arr[i][j] = 1
                cnt += 1
                back(cnt)
                arr[i][j] = 0
                cnt -= 1


def bfs():
    visited = [[0] * M for _ in range(N)]
    for i, j in virus:
        visited[i][j] = 1
    cnt = 0

    tmp_virus = deque([])

    for i in virus:
        tmp_virus.append(i)

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                visited[i][j] = 1

    while tmp_virus:
        r, c = tmp_virus.popleft()

        for dr, dc in d:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and arr[nr][nc] == 0:
                tmp_virus.append((nr, nc))
                visited[nr][nc] = 1

    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0:
                cnt += 1

    return cnt

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
virus = []
best_safe_area = -1e9

for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            virus.append((i, j))

back(0)
print(best_safe_area)