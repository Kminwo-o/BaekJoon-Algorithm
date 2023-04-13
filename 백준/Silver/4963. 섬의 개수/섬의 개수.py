from collections import deque

def bfs(x, y):
    visited[x][y] = 1
    q = deque([(x, y)])

    while q:
        r, c = q.popleft()

        for dr, dc in d:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < h and 0 <= nc < w and not visited[nr][nc] and arr[nr][nc] == 1:
                visited[nr][nc] = 1
                q.append((nr, nc))

    return 1


while True:
    w, h = map(int, input().split())

    if not w and not h:
        break

    arr = [list(map(int, input().split())) for _ in range(h)]
    d = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
    total = 0
    visited = [[0] * w for _ in range(h)]

    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and not visited[i][j]:
                total += bfs(i, j)

    print(total)
