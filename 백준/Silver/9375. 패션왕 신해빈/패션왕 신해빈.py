import sys
input = sys.stdin.readline

T = int(input())
for i in range(T):
    n = int(input())
    clothes = {}
    for j in range(n):
        clothe_name, clothe_type = input().split() 
        if clothe_type not in clothes.keys():
            clothes[clothe_type] = 1
        else:
            clothes[clothe_type] += 1
    
    cnt = 1
    for i in clothes:
        cnt *= (clothes[i]+1)
    print(cnt-1)