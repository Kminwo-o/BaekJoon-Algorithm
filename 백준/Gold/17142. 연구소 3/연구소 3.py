import sys
from collections import deque
import copy

input = sys.stdin.readline


def complete(lst):
    for i in range(N):
        for j in range(N):
            if lst[i][j] == 0:
                return False
    return True

def bfs(lst):
    tmp_arr = copy.deepcopy(arr)
    queue = deque(lst)
    visited = [[0] * N for _ in range(N)]

    for i in queue:
        visited[i[0]][i[1]] = 1

    while queue:
        r, c, time = queue.popleft()

        for dr, dc in d:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc]:
                if tmp_arr[nr][nc] == 0:
                    tmp_arr[nr][nc] = time
                    visited[nr][nc] = 1
                    if time >= best_time:
                        return best_time
                    queue.append((nr, nc, time + 1))
                elif tmp_arr[nr][nc] == -1:
                    visited[nr][nc] = 1
                    queue.append((nr, nc, time + 1))

    max_time = 0

    if not complete(tmp_arr):
        return best_time

    for i in tmp_arr:
        max_time = max(max(i), max_time)

    return max_time


def virus(idx, cnt):
    global best_time
    if cnt == M:
        time = bfs(use_virus)
        best_time = min(best_time, time)
        return

    for i in range(idx, len_virus):
        if not virus_used[i]:
            virus_used[i] = 1
            use_virus.append(virus_lst[i])
            virus(i+1, cnt + 1)
            virus_used[i] = 0
            use_virus.pop()

N, M = map(int, input().split())
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
arr = [list(map(int, input().split())) for _ in range(N)]
virus_lst = []
use_virus = []
best_time = 1e9

for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            arr[i][j] = -1
            virus_lst.append((i, j, 1))

        elif arr[i][j] == 1:
            arr[i][j] = -2

len_virus = len(virus_lst)
virus_used = [0] * len_virus

virus(0, 0)

if best_time == 1e9:
    best_time = -1

print(best_time)