import sys

input = sys.stdin.readline
from collections import deque

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(lst):

    while tomato_lst:
        a, b = tomato_lst.popleft()

        for dr, dc in d:
            nr = a + dr
            nc = b + dc

            if 0 <= nr < M and 0 <= nc < N and tomato_bat[nr][nc] == 0:
                tomato_bat[nr][nc] = tomato_bat[a][b] + 1
                tomato_lst.append((nr, nc))

    max_ = 0

    for i in range(M):
        for j in range(N):
            if tomato_bat[i][j] == 0:
                max_ = 0
                return max_

            if max_ < tomato_bat[i][j]:
                max_ = tomato_bat[i][j]

    return max_

N, M = map(int, input().split())

tomato_bat = [list(map(int, input().split())) for _ in range(M)]
tomato_lst = deque()

for i in range(M):
    for j in range(N):
        if tomato_bat[i][j] == 1:
            tomato_lst.append((i, j))

print(bfs(tomato_lst)-1)