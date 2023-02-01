import sys
input = sys.stdin.readline

N = int(input())
sugar = [-1 for _ in range(5001)]

sugar[3] = 1
sugar[5] = 1

if N <= 5:
    print(sugar[N])

else:
    for i in range(6, N+1):
        if i % 5 == 0:
            sugar[i] = sugar[i-5] + 1
        
        elif i % 3 == 0:
            sugar[i] = sugar[i-3] + 1

        elif sugar[i-3] > 0 and sugar[i-5] > 0:
            sugar[i] = min(sugar[i-3], sugar[i-5]) + 1
    
    print(sugar[N])