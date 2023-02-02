import sys
input = sys.stdin.readline

T = int(input())
num_lst = [0] * 11
num_lst[0] = 1
num_lst[1] = 2
num_lst[2] = 4

for _ in range(T):
    n = int(input())
    if n > 3:
        for j in range(3,n):
            num_lst[j] = num_lst[j-3] + num_lst[j-2] + num_lst[j-1]

    print(num_lst[n-1])