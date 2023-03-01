import sys

input = sys.stdin.readline
from collections import deque

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(lst):
    visited = [[0] * N for _ in range(M)]
    queue = deque([])

    for i in tomato_lst:
        queue.append(i)
        visited[i[0]][i[1]] = 1

    while queue:
        a, b = queue.popleft()

        for dr, dc in d:
            nr = a + dr
            nc = b + dc

            if 0 <= nr < M and 0 <= nc < N and tomato_bat[nr][nc] == '0' and not visited[nr][nc]:
                visited[nr][nc] = visited[a][b] + 1
                tomato_bat[nr][nc] = '1'
                queue.append((nr, nc))

    max_ = 0

    for i in range(M):
        for j in range(N):
            if tomato_bat[i][j] == '0':
                max_ = 0
                return max_

            if max_ < visited[i][j]:
                max_ = visited[i][j]

    return max_

N, M = map(int, input().split())

tomato_bat = [input().split() for _ in range(M)]
tomato_lst = []

for i in range(M):
    for j in range(N):
        if tomato_bat[i][j] == '1':
            tomato_lst.append((i, j))

print(bfs(tomato_lst)-1)