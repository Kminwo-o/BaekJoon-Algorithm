import sys
input = sys.stdin.readline

def dfs(x, y):
    if x == N-1 and y == M-1:
        return 1
    cnt = 0
    for dx, dy in d:
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M:
            if target <= arr[nx][ny] < arr[x][y]:
                if visited[nx][ny] >= 0:
                    cnt += visited[nx][ny]
                else:
                    cnt += dfs(nx,ny)
    visited[x][y] = cnt
    return cnt

d = [(-1,0),(1,0),(0,-1),(0,1)]
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
target = arr[N-1][M-1]
visited = [[-1] * M for _ in range(N)]

print(dfs(0,0))