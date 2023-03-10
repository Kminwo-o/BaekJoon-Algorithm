import sys
from collections import deque

input = sys.stdin.readline


def bfs(h1, h2):
    global second
    visited1[h1][h2] = 3

    jihoon.append((h1, h2, 0))

    while jihoon:
        while fire:
            s = fire[0][2]

            if s != second:
                break

            f1, f2, s = fire.popleft()
            visited2[f1][f2] = 1

            s += 1

            for dr, dc in d:
                nf1 = f1 + dr
                nf2 = f2 + dc

                if 0 <= nf1 < R and 0 <= nf2 < C and (arr[nf1][nf2] == '.' or arr[nf1][nf2] == 'J'):
                    if visited2[nf1][nf2] != 1:
                        visited2[nf1][nf2] = 1
                        arr[nf1][nf2] = 'F'
                        fire.append((nf1, nf2, s))

        while jihoon:
            b = jihoon[0][2]

            if b != second:
                break

            h1, h2, b = jihoon.popleft()

            b += 1

            for dr, dc in d:
                nh1 = h1 + dr
                nh2 = h2 + dc

                if 0 > nh1 or nh1 == R or 0 > nh2 or nh2 == C:
                    return True

                elif arr[nh1][nh2] == '.' and visited1[nh1][nh2] == 0:
                    jihoon.append((nh1, nh2, b))
                    visited1[nh1][nh2] = 3

        second += 1

    return False


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
R, C = map(int, input().strip().split())

arr = [list(input().strip()) for _ in range(R)]
visited1 = [[0] * C for _ in range(R)]
visited2 = [[0] * C for _ in range(R)]
fire = deque([])
jihoon = deque([])
second = 0

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'J':
            h1, h2 = i, j

        elif arr[i][j] == 'F':
            fire.append((i, j, 0))

if bfs(h1, h2):
    print(second+1)
else:
    print('IMPOSSIBLE')