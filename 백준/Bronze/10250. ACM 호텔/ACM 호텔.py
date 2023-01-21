import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    H,W,N = map(int,input().split())
    checkin_lst = []
    cnt = 0

    for j in range(1, W+1):
        if cnt == N:
            break

        for k in range(1, H+1):
            if cnt == N:
                break
            checkin_lst.append((k*100 + j))
            cnt += 1
    print(checkin_lst[-1])