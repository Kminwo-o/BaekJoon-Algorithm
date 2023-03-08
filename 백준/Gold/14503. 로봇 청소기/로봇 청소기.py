import sys

input = sys.stdin.readline


def check(x, y, idx):
    while True:
        if arr[x][y] == 0:
            arr[x][y] = 2

        for dr, dc in d:
            nr = x + dr
            nc = y + dc

            if 0 <= nr < N and 0 <= nc < M and arr[nr][nc] == 0:
                idx += -1
                if idx < 0:
                    idx = 3
                nr = x + d[idx][0]
                nc = y + d[idx][1]

                if arr[nr][nc] == 0:
                    x = nr
                    y = nc
                break

        else:
            if idx == 0:
                nr = x + d[2][0]
                nc = y + d[2][1]

                if 0 <= nr < N and 0 <= nc < M and (arr[nr][nc] == 0 or arr[nr][nc] == 2):
                    x = nr
                    y = nc
                else:
                    return
            elif idx == 1:
                nr = x + d[3][0]
                nc = y + d[3][1]

                if 0 <= nr < N and 0 <= nc < M and (arr[nr][nc] == 0 or arr[nr][nc] == 2):
                    x = nr
                    y = nc

                else:
                    return

            elif idx == 2:
                nr = x + d[0][0]
                nc = y + d[0][1]

                if 0 <= nr < N and 0 <= nc < M and (arr[nr][nc] == 0 or arr[nr][nc] == 2):
                    x = nr
                    y = nc
                else:
                    return

            elif idx == 3:
                nr = x + d[1][0]
                nc = y + d[1][1]

                if 0 <= nr < N and 0 <= nc < M and (arr[nr][nc] == 0 or arr[nr][nc] == 2):
                    x = nr
                    y = nc
                else:
                    return

N, M = map(int, input().split())

r, c, idx = map(int, input().split())
d = [(-1, 0), (0, 1), (1, 0), (0, -1)]
cnt = 0

arr = [list(map(int, input().split())) for _ in range(N)]

check(r, c, idx)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            cnt += 1

print(cnt)