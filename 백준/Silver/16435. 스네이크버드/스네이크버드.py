N, L = map(int,input().split())
lst = list(map(int, input().split()))

lst.sort()

for i in lst:
    if L >= i:
        L += 1

print(L)