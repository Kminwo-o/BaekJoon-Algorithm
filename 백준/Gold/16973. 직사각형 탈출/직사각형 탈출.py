import sys
input = sys.stdin.readline
from collections import deque

def check(x, y):
    for x_w, y_w in walls:
        if x <= x_w < x + h and y <= y_w < y + w:
            return False
    return True

def bfs(x, y):
    q = deque()
    q.append((x, y, 0))
    visited = [[False] * m for _ in range(n)]

    while q:
        now_x, now_y, cnt = q.popleft()
        visited[now_x][now_y] = True

        if now_x == fr-1 and now_y == fc-1:
            return cnt
        
        for i in range(4):
            next_x = now_x + dir[i][0]
            next_y = now_y + dir[i][1]

            if 0 <= next_x < n and 0 <= next_y < m and 0 <= next_x + h -1 < n and 0 <= next_y + w - 1 < m:
                if not visited[next_x][next_y]:
                    if check(next_x, next_y):
                        visited[next_x][next_y] = True
                        q.append((next_x, next_y, cnt+1))
    return -1

n, m = map(int,input().split())
dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

h, w, sr, sc, fr, fc = map(int, input().split())

walls = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            walls.append((i,j))

print(bfs(sr-1, sc-1))