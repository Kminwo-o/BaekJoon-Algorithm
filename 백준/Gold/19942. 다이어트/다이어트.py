import copy
import sys

input = sys.stdin.readline


def check():
    for i in range(4):
        if Buy_nutri[i] < need_nutri[i]:
            return 0
    return 1


def permutation(idx):
    global min_value, possible_lst

    if check() == 1:
        possible_lst = copy.deepcopy(used)
        min_value = Buy_nutri[4]
        return

    for i in range(idx ,N):
        if not used[i]:
            Buy_nutri[0] += nutri_lst[i][0]
            Buy_nutri[1] += nutri_lst[i][1]
            Buy_nutri[2] += nutri_lst[i][2]
            Buy_nutri[3] += nutri_lst[i][3]
            Buy_nutri[4] += nutri_lst[i][4]
            used[i] = 1
            if min_value > Buy_nutri[4]:
                permutation(i + 1)
            used[i] = 0
            Buy_nutri[0] -= nutri_lst[i][0]
            Buy_nutri[1] -= nutri_lst[i][1]
            Buy_nutri[2] -= nutri_lst[i][2]
            Buy_nutri[3] -= nutri_lst[i][3]
            Buy_nutri[4] -= nutri_lst[i][4]

N = int(input())
need_nutri = list(map(int, input().split()))
nutri_lst = [list(map(int, input().split())) for _ in range(N)]
Buy_nutri = [0] * 5
possible_lst = []
min_value = 1e9
used = [0] * N
ans = []

permutation(0)

if min_value == 1e9:
    print(-1)
else:
    print(min_value)
    for i in range(len(possible_lst)):
        if possible_lst[i] == 1:
            ans.append(i+1)
    print(*ans, sep=' ')