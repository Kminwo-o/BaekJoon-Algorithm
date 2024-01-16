import sys
input = sys.stdin.readline

dir = ((-1, 0), (1, 0), (0 ,-1), (0, 1))

def dfs(x, y, cnt, visited):
    global answer
    if (cnt == k):
        if (x == 0 and y == m-1):
            answer += 1
        return

    for nr, nc in dir:
        nx = x + nr
        ny = y + nc

        if (0 <= nx < n and 0 <= ny < m and visited[nx][ny] == False and arr[nx][ny] != "T"):
            visited[nx][ny] = True
            dfs(nx, ny, cnt+1, visited)
            visited[nx][ny] = False

    return

n, m, k = map(int, input().split())
arr = [list(input().strip()) for _ in range(n)]
answer = 0
visited = [[False] * m for _ in range(n)]
visited[n-1][0] = True

dfs(n-1, 0, 1, visited)

print(answer)