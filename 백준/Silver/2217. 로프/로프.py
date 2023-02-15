import sys
input = sys.stdin.readline

N = int(input())
rope = []

for i in range(N):
    rope.append(int(input()))
    
rope.sort()
real_max = []

for i in range(N):
    real_max.append(rope[i] * (N-i))

print(max(real_max))