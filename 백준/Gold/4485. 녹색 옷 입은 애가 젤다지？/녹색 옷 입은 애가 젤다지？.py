import heapq
import sys
input = sys.stdin.readline

def dijkstra():
    hq = []
    visited = [[1e9] * n for _ in range(n)]
    heapq.heappush(hq, (arr[0][0], 0, 0))

    while hq:
        loopy, x, y = heapq.heappop(hq)

        if (visited[x][y] < loopy):
            continue

        if (x == y == n-1):
            return loopy

        for i in range(4):
            nx = x + dir[i][0]
            ny = y + dir[i][1]

            if 0 <= nx < n and 0 <= ny < n:
                if visited[nx][ny] > loopy + arr[nx][ny]:
                    heapq.heappush(hq, (loopy + arr[nx][ny], nx, ny))
                    visited[nx][ny] = loopy + arr[nx][ny]


dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]
num = 0

while True:
    num += 1
    n = int(input())

    if n == 0:
        break

    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))

    answer = dijkstra()

    print(f'Problem {num}: {answer}')
