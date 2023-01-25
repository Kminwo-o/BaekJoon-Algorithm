import sys
input = sys.stdin.readline

N = int(input())
member_lst = list()

for i in range(N):
    member_lst.append(list(input().split()))

for i in member_lst:
    i[0] = int(i[0])

member_lst.sort(key=lambda x : x[0])

for i in member_lst:
    print(i[0], i[1])