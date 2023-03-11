from itertools import combinations
import sys
input = sys.stdin.readline

def distance():
    global ans
    
    for i in combinations(chicken, M):
        total_dis = 0
        for j in house:
            dis = 1e9
            for k in range(M):
                dis = min(dis, abs(j[0] - i[k][0]) + abs(j[1] - i[k][1]))
            
            total_dis += dis
        
        ans = min(ans, total_dis)

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
chicken = []
house = []
ans = 1e9

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append((i,j))

        elif arr[i][j] == 2:
            chicken.append((i,j))

distance()

print(ans)