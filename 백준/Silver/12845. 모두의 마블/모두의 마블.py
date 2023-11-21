import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
max_ = max(lst)

for i in range(n):
    if lst[i] == max_:
        start = i
        break

answer = 0
for i in range(n):
    if (start == i):
        continue
    answer += max_ + lst[i]

print(answer)