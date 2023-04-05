from collections import deque

def bfs(x, y):
    visited[x][y] = 1
    queue = deque([(x,y)])
    del_lst = []

    while queue:
        r, c = queue.popleft()
        sea = 0

        for dr, dc in d:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < N and 0 <= nc < M:
                if arr[nr][nc] == 0:
                    sea += 1
                elif arr[nr][nc] != 0 and not visited[nr][nc]:
                    visited[nr][nc] = 1
                    queue.append((nr,nc))

        if sea > 0:
            del_lst.append((r, c, sea))

    for i, j, sea in del_lst:
        arr[i][j] = max(0, arr[i][j] - sea)

    return 1

N,M = map(int, input().split())
d = [(-1,0),(1,0),(0,-1),(0,1)]
arr = [list(map(int,input().split())) for _ in range(N)]
year = 0
check = True
ice_mountain = []
del_lst = []

for i in range(N):
    for j in range(M):
        if arr[i][j] != 0:
            ice_mountain.append((i,j))

while ice_mountain:
    visited = [[0]*M for _ in range(N)]
    cnt = 0

    for i,j in ice_mountain:
        if arr[i][j] and not visited[i][j]:
            cnt += bfs(i,j)

        if arr[i][j] == 0:
            del_lst.append((i,j))

    if cnt > 1:
        print(year)
        break

    ice_mountain = sorted(list(set(ice_mountain) - set(del_lst)))
    year += 1

if cnt < 2:
    print(0)