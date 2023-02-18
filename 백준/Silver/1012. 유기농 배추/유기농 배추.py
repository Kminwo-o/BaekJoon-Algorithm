import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

def dfs(r,c):
    global cnt
    if bat[r][c] == 1:
        bat[r][c] = 0

        
        for dr, dc in d:
            nr = r + dr
            nc = c + dc
            
            if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and bat[nr][nc] == 1:
                dfs(nr,nc)

T = int(input())

for _ in range(T):
    M,N,K = map(int, input().split())
    bat = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    cnt = 0

    for _ in range(K):
        c, r = map(int, input().split())
        bat[r][c] = 1

    d = [(-1, 0),(1, 0),(0,-1),(0,1)]

    for i in range(N):
        for j in range(M):
            if bat[i][j] == 1:
                dfs(i,j)
                cnt += 1

    print(cnt)