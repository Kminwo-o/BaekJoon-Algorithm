import sys
input = sys.stdin.readline

N,M = map(int,input().split())
tmp = max(N,M)
M = min(N,M)
N = tmp
best_min = 1
worst_max = 0

for i in range(2, M):
    if N % M == 0:
        best_min = M
        worst_max = N
        break
    
    elif N % i == 0 and M % i == 0:
        if best_min < i:
            best_min = i
    
else:
    j = 2
    k = 2
    tmpN = N
    tmpM = M
    while tmpN != tmpM:
        if tmpN > tmpM:
            tmpM = M * j
            j += 1
        else:
            tmpN = N * k
            k += 1
    worst_max = tmpN

print(f'{best_min}\n{worst_max}')