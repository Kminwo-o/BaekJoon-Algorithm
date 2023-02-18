import sys
from itertools import permutations
input = sys.stdin.readline

X = input().strip()
lst = list(permutations(X, len(X)))
new_lst = []

for i in lst:
    if ''.join(i) not in new_lst:
        new_lst.append(''.join(i))

new_lst.sort()
if new_lst[-1] == X:
    print(0)
else:
    for i in range(len(new_lst)):
        if new_lst[i] == X:
            print(new_lst[i+1])