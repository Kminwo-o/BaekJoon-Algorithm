import sys
input = sys.stdin.readline
from collections import deque

d = [(-1,0), (1,0), (0,-1), (0,1)]

def bfs(x,y):
    visited = [[0] * M for _ in range(N)]
    cnt = 0
    queue = deque([(x,y)])
    visited[x][y] = 1
    
    while queue:
        cr, cc = queue.popleft()
        
        for i,j in d:
            nr = cr + i
            nc = cc + j
            
            if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and island[nr][nc] == 'L':
                visited[nr][nc] = visited[cr][cc] + 1
                cnt = max(cnt, visited[nr][nc])
                queue.append((nr,nc))
    
    return cnt-1

N,M = map(int, input().split())
island = [list(input().strip()) for _ in range(N)]
ans = 0

for i in range(N):
    for j in range(M):
        if island[i][j] == 'L':
            ans = max(ans, bfs(i,j))
            
print(ans)