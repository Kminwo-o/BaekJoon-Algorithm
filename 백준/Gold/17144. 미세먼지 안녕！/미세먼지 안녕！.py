import sys
from collections import deque

input = sys.stdin.readline

d = [(-1, 0), (0, -1), (1, 0), (0, 1)]  # 상좌하우


# 공기 청정기
def air_clean():
    rocation = deque([])

    for i in range(2):
        idx = 3
        tmp_val = 0
        if i == 0:
            a, b = air_cleaner[i]
            rocation.append((a, b + 1))
        else:
            a, b = air_cleaner[i]
            rocation.append((a, b + 1))

        while rocation:
            x, y = rocation.popleft()
            tmp_val, arr[x][y] = arr[x][y], tmp_val

            nx = x + d[idx][0]
            ny = y + d[idx][1]

            if 0 > nx or nx >= R or 0 > ny or ny >= C:
                if i == 0:
                    idx = (idx + 1) % 4
                else:
                    idx = (idx - 1) % 4

                nx = x + d[idx][0]
                ny = y + d[idx][1]

            if arr[nx][ny] >= 0:
                rocation.append((nx, ny))


# 확산 시키기
def diffuse():
    tmp_arr = [[0] * C for _ in range(R)]
    loca = deque([])
    for i in range(R):
        for j in range(C):
            if arr[i][j] > 0:
                loca.append((i, j))

    while loca:
        r, c = loca.popleft()

        cnt = 0
        for dr, dc in d:
            nr = r + dr
            nc = c + dc

            if 0 <= nr < R and 0 <= nc < C and arr[nr][nc] != -1:
                cnt += 1
                tmp_arr[nr][nc] += arr[r][c] // 5

        if cnt > 0:
            tmp_arr[r][c] += (arr[r][c]) - (arr[r][c] // 5) * (cnt)

    for i in range(R):
        for j in range(C):
            if tmp_arr[i][j] > 0:
                arr[i][j] = tmp_arr[i][j]


R, C, T = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(R)]
air_cleaner = []

# air cleaner의 0이 상, 1이 하
for i in range(R):
    for j in range(1):
        if arr[i][j] == -1:
            air_cleaner.append((i, j))

second = 0
while second != T:
    second += 1
    diffuse()
    air_clean()

total = 0

for i in range(R):
    for j in range(C):
        if arr[i][j] > 0:
            total += arr[i][j]
            
print(total)