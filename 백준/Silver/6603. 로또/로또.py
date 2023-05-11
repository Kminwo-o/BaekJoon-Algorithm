from itertools import combinations
while True:
    lst = list(map(int, input().split()))
    if lst[0] == 0: break
    lst.pop(0)
    for i in list(combinations(lst, 6)):
        print(*i)
    print()