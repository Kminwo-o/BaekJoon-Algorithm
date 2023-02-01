import sys
input = sys.stdin.readline

T = int(input())
stair_lst = [0] * 301
point_lst = [0] * 301

for i in range(T): 
    stair_lst[i] = int(input())

point_lst[0] = stair_lst[0]
point_lst[1] = stair_lst[0] + stair_lst[1]
point_lst[2] = max(stair_lst[0] + stair_lst[2], stair_lst[1] + stair_lst[2])

for i in range(3, T):
    point_lst[i] = max(point_lst[i-3] + stair_lst[i-1] + stair_lst[i], point_lst[i-2] + stair_lst[i])

print(point_lst[T-1])