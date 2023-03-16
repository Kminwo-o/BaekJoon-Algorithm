import sys
from collections import deque
from itertools import combinations
import copy

input = sys.stdin.readline

def bfs(loca,distance):
    attack = deque()
    attack.append([N, loca , distance])
    visited = [[0 for _ in range(M)] for _ in range(N+1)]
    visited[N][loca] = 1
    possible = []

    while attack:
        r, c, distance = attack.popleft()

        if tmp_arr[r][c] == 1 and distance <= D:
            possible.append([distance, c, r])
            continue
        
        for dr, dc in d:
            nr = r + dr
            nc = c + dc
            if 0 <= nr < N and 0 <= nc < M:
                if visited[nr][nc] == 0 and distance <= D:
                    attack.append([nr,nc,distance+1])
                    visited[nr][nc] = 1
    
    return sorted(possible)

def next_round():
    for i in range(N-1, 0, -1):
        for j in range(M):
            tmp_arr[i][j] = tmp_arr[i-1][j]

    for i in range(M):
        tmp_arr[0][i] = 0

def is_empty(tmp_arr):
    for i in range(N):
        for j in range(M):
            if tmp_arr[i][j] == 1:
                return False
    return True

d = [(0, -1), (-1, 0), (0, 1)]

N, M, D = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)] + [[-1] * M]
best_point = 0

archer = [i for i in range(M)]

for i in combinations(archer, 3):
    tmp_arr = copy.deepcopy(arr)
    point = 0

    while not is_empty(tmp_arr):
        attack_possible = []
        for j in range(3):
            search_monster = bfs(i[j], 0)

            if search_monster:
                search_monster = search_monster[0]
                attack_possible.append((search_monster[2], search_monster[1]))

        attack_possible = list(set(attack_possible))

        for j in attack_possible:
            tmp_arr[j[0]][j[1]] = 0
            point += 1
        
        next_round()
    
    best_point = max(best_point, point)

print(best_point)