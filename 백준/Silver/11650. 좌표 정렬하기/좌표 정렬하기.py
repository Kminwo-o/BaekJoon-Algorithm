import sys
input = sys.stdin.readline

N = int(input())
dot_list = list()

for i in range(N):
    dot_list.append(list(map(int, input().split()))) 

dot_list.sort(key=lambda x : (x[0], x[1]))

for i in dot_list:
    print(i[0], i[1])