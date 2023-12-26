import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    q = deque([])
    visited[x][y] = 1
    q.append((x, y))

    while q:
        r, c = q.popleft()

        for nx, ny in dir:
            nr = r + nx
            nc = c + ny

            if 0 <= nr < h and 0 <= nc < w:
                if visited[nr][nc] == 0 and arr[nr][nc] == "#":
                    visited[nr][nc] = 1
                    q.append((nr, nc)) 


dir = [[-1, 0], [1, 0], [0,  -1], [0, 1]]
T = int(input())
for i in range(T):
    cnt = 0
    h, w = map(int, input().split())
    arr = [[] for _ in range(h)]
    visited = [[0] * w for _ in range(h)]

    for j in range(h):
        arr[j] = list(input().strip())

    for j in range(h):
        for k in range(w):
            if visited[j][k] or arr[j][k] == ".":
                continue

            bfs(j, k)
            cnt += 1
    
    print(cnt)
