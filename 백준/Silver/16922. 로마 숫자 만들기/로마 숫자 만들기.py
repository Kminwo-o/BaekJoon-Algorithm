from itertools import combinations_with_replacement

num = [1,5,10,50]
N = int(input())
sett = set()

for lst in combinations_with_replacement(num, N):
    sett.add(sum(lst))

print(len(sett))