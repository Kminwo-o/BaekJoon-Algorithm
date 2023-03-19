import sys
import copy
input = sys.stdin.readline

def switch(arr, idx):
    if arr[idx] == 0:
        arr[idx] = 1
    else:
        arr[idx] = 0

    if arr[idx - 1] == 0:
        arr[idx - 1] = 1
    else:
        arr[idx - 1] = 0

    if idx != N - 1:
        if arr[idx + 1] == 0:
            arr[idx + 1] = 1
        else:
            arr[idx + 1] = 0

def partition(onoff, cnt):
    if cnt == 1:
        if onoff[0] == 0:
            onoff[0] = 1
        else:
            onoff[0] = 0

        if onoff[1] == 0:
            onoff[1] = 1
        else:
            onoff[1] = 0

    for i in range(1, N):
        if i == N - 1:
            if onoff[i-1] != after_lst[i-1]:
                switch(onoff, i)
                cnt += 1

        elif onoff[i-1] != after_lst[i-1]:
            switch(onoff, i)
            cnt += 1

        if onoff == after_lst:
            return cnt

    if onoff != after_lst:
        return -1

N = int(input())

befo_lst = list(map(int, input().strip()))
after_lst = list(map(int, input().strip()))
cnt = 0

ans1 = partition(copy.deepcopy(befo_lst), 0)
ans2 = partition(copy.deepcopy(befo_lst), 1)

if ans1 >= 0 and ans2 >= 0:
    print(min(ans1, ans2))

elif ans1 >= 0 and ans2 < 0:
    print(ans1)

elif ans1 < 0 and ans2 >= 0:
    print(ans2)

else:
    print(-1)