import sys

input = sys.stdin.readline

N = int(input())
lst = []
max_x = 0
max_y = 0

for i in range(N):
    x, y = map(int, input().split())
    lst.append((x, y))

dohwazi = [[0] * 100 for _ in range(100)]

for a, b in lst:
    for i in range(a, a + 10):
        for j in range(b, b + 10):
            dohwazi[j][i] = 1

result = 0

for i in range(100):
    result += sum(dohwazi[i])
        
print(result)