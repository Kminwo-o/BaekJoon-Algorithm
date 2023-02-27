import sys
input = sys.stdin.readline
from collections import deque

def blindness_test(x, y, color, v):
    v[x][y] = 1
    queue = deque([(x, y)])

    if painting[x][y] == 'G':
        painting[x][y] = 'R'

    d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    while queue:
        cr, cc = queue.popleft()

        for dr, dc in d:
            nr = cr + dr
            nc = cc + dc

            if 0 <= nr < N and 0 <= nc < N and not v[nr][nc] and painting[nr][nc] == color:
                queue.append((nr, nc))
                v[nr][nc] = 1

                if painting[nr][nc] == 'G':
                    painting[nr][nc] = 'R'

    return 1


N = int(input())
painting = [list(input().strip()) for _ in range(N)]
visited1 = [[0] * N for _ in range(N)]
visited2 = [[0] * N for _ in range(N)]
not_bli = []
bli = []
area1 = 0
area2 = 0

for i in range(N):
    for j in range(N):
        if not visited1[i][j]:
            area1 += blindness_test(i, j, painting[i][j], visited1)

for i in range(N):
    for j in range(N):
        if not visited2[i][j]:
            area2 += blindness_test(i, j, painting[i][j], visited2)

print(area1, area2)
