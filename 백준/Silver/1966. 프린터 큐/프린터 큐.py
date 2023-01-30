import sys 
from collections import deque
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N,M = map(int, input().split())
    impotant = deque(map(int,input().split()))
    cnt = 1
    
    while impotant:
        if impotant[0] == max(impotant):
            if M == 0:
                break
            impotant.popleft()
            cnt += 1
            M -= 1
            if M < 0:
                M = len(impotant) - 1

        else:
            impotant.rotate(-1)
            M -= 1
            if M < 0:
                M = len(impotant) - 1
    print(cnt)