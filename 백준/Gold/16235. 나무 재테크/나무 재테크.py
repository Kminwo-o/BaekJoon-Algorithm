# 땅의 크기는 N*N
# 각각의 칸은 r,c == 1부터 시작한다.
# 처음에는 모든 칸에 양분이 5
# M개의 나무를 구입해 땅에 심는다.

# 봄에는 나무가 나이만큼 양문을 먹고 나이가 1 증가,
# 땅의 양분이 부족해 나이만큼 먹지 못하면 즉시 사망

# 여름에는 죽은 나무가 양분이 된다. 소수점은 버린다.
# 나무의 나이를 // 2로 나눈 값이 자리에 양분이 된다.

# 가을에는 나무가 번식 한다. 번식하는 나무는 5의 배수
# 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
# 맵 밖에는 나무가 생기지 않는다.

# 겨울에는 S2D2가 땅을 돌아다니며 땅에 양분을 추가한다.
# 각 칸에 추가되는 양분의 양은 A[r][c]이고 입력으로 주어진다.

# K년 이후 상도의 땅의 살아있는 나무 개수를 구해라

import sys
from collections import deque
input = sys.stdin.readline

def spring():
    for i in range(N):
        for j in range(N):
            tree_len = len(tree_lst[i][j])

            for k in range(tree_len):
                if manure[i][j] < tree_lst[i][j][k]:
                    for _ in range(k, tree_len):
                        dead_tree_lst.append((i, j, tree_lst[i][j].pop()))
                    break
                else:
                    manure[i][j] -= tree_lst[i][j][k]
                    tree_lst[i][j][k] += 1

def summer():
    while dead_tree_lst:
        x,y,z = dead_tree_lst.pop()
        manure[x][y] += (z // 2)

def fall():
    for i in range(N):
        for j in range(N):
            for k in range(len(tree_lst[i][j])):
                if tree_lst[i][j][k] % 5 == 0:
                    for dr, dc in d:
                        nx = i + dr
                        ny = j + dc

                        if 0 <= nx < N and 0 <= ny < N:
                            tree_lst[nx][ny].appendleft(1)

def winter():
    for i in range(N):
        for j in range(N):
            manure[i][j] += A[i][j]

N, M, K = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
manure = [[5] * N for _ in range(N)]
tree_lst = [[deque([]) for _ in range(N)] for _ in range(N)]
dead_tree_lst = []
d = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]
for _ in range(M):
    x, y, z = map(int, input().split())
    tree_lst[x-1][y-1].append(z)

year = 0
while year < K:
    spring()
    summer()
    fall()
    winter()
    year += 1

tree = 0
for i in range(N):
    for j in range(N):
        tree += len(tree_lst[i][j])

print(tree)