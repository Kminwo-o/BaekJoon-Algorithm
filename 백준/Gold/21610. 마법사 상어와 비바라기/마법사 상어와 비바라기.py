import sys
from collections import deque
input = sys.stdin.readline

def Rain_Dance():
    not_cloud = [[0] * N for _ in range(N)]
    r, c = move_command.popleft()
    for i in sky_cloud:
        i[0] = (i[0] + (d[r - 1][0] * c)) % N
        i[1] = (i[1] + (d[r - 1][1] * c)) % N

    for i in sky_cloud:
        not_cloud[i[0]][i[1]] = 1
        arr[i[0]][i[1]] += 1

    for i in sky_cloud:
        cnt = 0
        for dr, dc in d_d:
            nr = i[0] + dr
            nc = i[1] + dc

            if 0 <= nr < N and 0 <= nc < N and arr[nr][nc] > 0:
                cnt += 1

        arr[i[0]][i[1]] += cnt

    for i in range(N):
        for j in range(N):
            if arr[i][j] >= 2 and not not_cloud[i][j]:
                not_cloud[i][j] = 1
                arr[i][j] -= 2
                new_cloud.append([i, j])

def water_copy(r, c):
    global new_cloud
    not_cloud = [[0] * N for _ in range(N)]
    for i in new_cloud:
        i[0] = (i[0] + (d[r - 1][0] * c)) % N
        i[1] = (i[1] + (d[r - 1][1] * c)) % N

    for i in new_cloud:
        not_cloud[i[0]][i[1]] = 1
        arr[i[0]][i[1]] += 1

    for i in new_cloud:
        cnt = 0
        for dr, dc in d_d:
            nr = i[0] + dr
            nc = i[1] + dc

            if 0 <= nr < N and 0 <= nc < N and arr[nr][nc] > 0:
                cnt += 1

        arr[i[0]][i[1]] += cnt

    new_cloud = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] >= 2 and not not_cloud[i][j]:
                not_cloud[i][j] = 1
                arr[i][j] -= 2
                new_cloud.append([i, j])

d_d = [(-1, -1), (-1, 1), (1, -1), (1, 1)]
d = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
move_command = deque([tuple(map(int, input().split())) for _ in range(M)])
sky_cloud = [[N - 1, 0], [N - 1, 1], [N - 2, 0], [N - 2, 1]]
new_cloud = []
total = 0
Rain_Dance()

while move_command:
    r, c = move_command.popleft()
    water_copy(r, c)

for i in arr:
    total += sum(i)

print(total)