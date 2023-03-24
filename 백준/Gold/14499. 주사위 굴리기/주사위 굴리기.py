import sys

input = sys.stdin.readline


def dice_rolling(num):
    global x, y
    if num == 1:
        nx = x + d[num-1][0]
        ny = y + d[num-1][1]

        if 0 <= nx < N and 0 <= ny < M:
            x, y = nx, ny

            dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]

            if arr[x][y] == 0:
                arr[x][y] = dice[5]
            else:
                dice[5] = arr[x][y]
                arr[x][y] = 0

            return dice[0]

    elif num == 2:
        nx = x + d[num-1][0]
        ny = y + d[num-1][1]

        if 0 <= nx < N and 0 <= ny < M:
            x, y = nx, ny

            dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]

            if arr[x][y] == 0:
                arr[x][y] = dice[5]
            else:
                dice[5] = arr[x][y]
                arr[x][y] = 0

            return dice[0]

    elif num == 3:
        nx = x + d[num-1][0]
        ny = y + d[num-1][1]

        if 0 <= nx < N and 0 <= ny < M:
            x, y = nx, ny

            dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]

            if arr[x][y] == 0:
                arr[x][y] = dice[5]
            else:
                dice[5] = arr[x][y]
                arr[x][y] = 0

            return dice[0]

    elif num == 4:
        nx = x + d[num-1][0]
        ny = y + d[num-1][1]

        if 0 <= nx < N and 0 <= ny < M:
            x, y = nx, ny

            dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

            if arr[x][y] == 0:
                arr[x][y] = dice[5]
            else:
                dice[5] = arr[x][y]
                arr[x][y] = 0

            return dice[0]
    
    return -1

N, M, x, y, K = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
dice = [0] * 6
command = list(map(int, input().split()))
d = [(0, 1), (0, -1), (-1, 0), (1, 0)]

for i in command:
    ans = dice_rolling(i)
    if ans >= 0:
        print(ans)