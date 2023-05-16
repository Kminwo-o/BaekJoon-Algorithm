import sys
input = sys.stdin.readline

N = int(input())
village = []
total = 0
for _ in range(N):
    X, A = map(int,input().split())
    village.append((X,A))
    total += A

village.sort()

person = 0
for i in range(N):
    person += village[i][1]

    if person >= total / 2:
        print(village[i][0])
        break