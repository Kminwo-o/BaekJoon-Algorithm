import sys
input = sys.stdin.readline

def impossible(idx):
    for i in range(N):
        if i == idx:
            continue
        else:
            if egg_lst[i][0] > 0:
                return False
    return True

def egg_crash(idx):
    global ans
    if idx == N:
        broken_egg = 0
        for i in range(N):
            if egg_lst[i][0] <= 0:
                broken_egg += 1
        ans = max(ans, broken_egg)
        return

    if egg_lst[idx][0] <= 0:
        egg_crash(idx + 1)
        return     
    
    if impossible(idx):
        ans = max(ans, N-1)
        return

    for i in range(N):
        if i == idx:
            continue
        elif egg_lst[i][0] <= 0:
            continue
        else:
            egg_lst[idx][0] -= egg_lst[i][1]
            egg_lst[i][0] -= egg_lst[idx][1]
            egg_crash(idx + 1)
            egg_lst[idx][0] += egg_lst[i][1]
            egg_lst[i][0] += egg_lst[idx][1]

N = int(input())
egg_lst = [list(map(int, input().split())) for _ in range(N)]
ans = 0

egg_crash(0)

print(ans)