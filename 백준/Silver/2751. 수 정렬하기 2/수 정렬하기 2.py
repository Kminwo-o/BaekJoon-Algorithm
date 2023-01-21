import sys
input = sys.stdin.readline

N = int(input())
list_N = []

for i in range(N):
    list_N.append(int(input()))

list_N.sort()

for i in list_N:
    sys.stdout.write(f'{i}\n')