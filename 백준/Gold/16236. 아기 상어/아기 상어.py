import sys
from collections import deque

input = sys.stdin.readline


def target(lst):
    lst.sort(key=lambda x: (x[2], x[0], x[1]))
    return lst[0]


def help_mom():
    global baby_shark
    # arr에 아기 상어보다 작은 개체가 있는지
    for i in range(N):
        for j in range(N):
            if arr[i][j] < baby_shark[0]:
                return False
    return True


def bfs(x, y):
    global baby_shark, baby_now
    queue = deque([(x, y)])
    visited = [[0] * N for _ in range(N)]
    visited[x][y] = 1
    target_lst = []

    while queue:
        x, y = queue.popleft()

        for dr, dc in d:
            nx = x + dr
            ny = y + dc

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if 0 < arr[nx][ny] < baby_shark[0] and not visited[nx][ny] and arr[nx][ny] != 9:
                    visited[nx][ny] = visited[x][y] + 1
                    target_lst.append((nx, ny, visited[x][y]))

                elif arr[nx][ny] == baby_shark[0] or arr[nx][ny] == 0 or arr[nx][ny] == 9:
                    if not target_lst:
                        visited[nx][ny] = visited[x][y] + 1
                        queue.append((nx, ny))

    if len(target_lst) == 1:
        a, b, time = target_lst.pop()
        baby_shark[1] += 1
        arr[a][b] = 0
        if baby_shark[0] == baby_shark[1]:
            baby_shark[0] += 1
            baby_shark[1] = 0
        baby_now = (a, b)
        return time

    elif len(target_lst) >= 2:
        a, b, time = target(target_lst)
        baby_shark[1] += 1
        arr[a][b] = 0
        if baby_shark[0] == baby_shark[1]:
            baby_shark[0] += 1
            baby_shark[1] = 0
        baby_now = (a, b)
        return time

    else:
        return 0


def shark_adventure(second):
    global baby_now

    while not help_mom():
        result = bfs(baby_now[0], baby_now[1])
        if result:
            second += result
        else:
            return second

    return second


d = [(-1, 0), (0, -1), (0, 1), (1, 0)]
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
baby_shark = [2, 0]
fish_lst = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            baby_now = (i, j)
            break

print(shark_adventure(0))