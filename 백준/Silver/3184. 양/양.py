import sys
from collections import deque
input = sys.stdin.readline

dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(x, y):
    global w_ans, s_ans

    queue = deque([])
    queue.append((x, y))
    visited[x][y] = True

    sheep = 0
    wolf = 0

    while (queue):
        now = queue.popleft()
        
        if (arr[now[0]][now[1]] == "o"):
            sheep += 1
        
        if (arr[now[0]][now[1]] == "v"):
            wolf += 1
        
        for i in range(4):
            nx = now[0] + dir[i][0]
            ny = now[1] + dir[i][1]

            if (0 <= nx < r and 0 <= ny < c and arr[nx][ny] != "#" and visited[nx][ny] == False):
                visited[nx][ny] = True
                queue.append((nx, ny))
    
    if (wolf >= sheep):
        w_ans += wolf
    else:
        s_ans += sheep

    return

r, c = map(int, input().split())
arr = [[] * c for _ in range(r)]
visited = [[False] * c for _ in range(r)]

w_ans = 0
s_ans = 0

for i in range(r):
    arr[i] = list(input().strip())

for i in range(r):
    for j in range(c):
        if ((arr[i][j] == "v" or arr[i][j] == "o") and visited[i][j] == False):
            bfs(i, j)

print(s_ans, w_ans)