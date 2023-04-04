import sys
sys.setrecursionlimit(100000)

def dfs(x, y):
    for dx, dy in d:
        nx = x + dx
        ny = y + dy

        if 0 <= nx < N and 0 <= ny < N:
            if not visited[nx][ny] and L <= abs(arr[nx][ny] - arr[x][y]) <= R:
                visited[nx][ny] = 1
                country.append((nx, ny))
                dfs(nx,ny)

d = [(1,0),(0,1),(-1,0),(0,-1)]
N, L, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

date = 0
while True:
    visited = [[0] * N for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(N):
            country = []
            if not visited[i][j]:
                visited[i][j] = 1
                country.append((i, j))  
                dfs(i,j)
            
            if len(country) > 1:
                flag = True
                total = 0
                for r, c in country:
                    total += arr[r][c]
                avg = total // len(country)
                for r, c in country:
                    arr[r][c] = avg
    
    if not flag:
        print(date)
        break

    date += 1