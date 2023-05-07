import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num_lst = [0] + list(map(int, input().split()))

for i in range(1, N):
    num_lst[i+1] += num_lst[i]

for _ in range(M):
    s, e = map(int, input().split())
    print(num_lst[e] - num_lst[s-1])