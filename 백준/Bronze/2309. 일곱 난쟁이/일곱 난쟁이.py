from itertools import combinations
import sys
input = sys.stdin.readline

smaller = []

for _ in range(9):
    smaller.append(int(input()))

real_smaller = map(list, combinations(smaller, 7))

for i in real_smaller:
    if sum(i) == 100:
        i.sort()
        for j in i:
            print(j)
        break