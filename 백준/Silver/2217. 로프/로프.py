import sys
input = sys.stdin.readline

N = int(input())
rope = [0] * N

for i in range(N):
    rope[i] = (int(input()))

rope.sort()
max_ = 0

for i in range(N):
    max_ = max(max_ , rope[i] * (N-i))

print(max_)