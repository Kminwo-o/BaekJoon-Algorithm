n = int(input())
lst = set()
for i in range(n):
    lst.add(input())
lst = list(lst)
lst.sort()
lst.sort(key = len)
for i in lst:
    print(i)