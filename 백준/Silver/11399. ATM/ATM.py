import sys
input = sys.stdin.readline

N = int(input())

P = list(map(int,input().split()))

P.sort()
time = []
time.append(P[0])

for i in range(1, len(P)):
    time.append(time[i-1] + P[i])
    

print(sum(time))