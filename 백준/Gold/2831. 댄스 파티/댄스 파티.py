import sys
input = sys.stdin.readline

N = int(input())

man_list = list(map(int, input().split()))
woman_list = list(map(int, input().split()))

man_list.sort()
woman_list.sort()

s = 0
e = N-1
ans = 0

while s < N and 0 <= e:
    if man_list[s] < 0 and 0 < woman_list[e] and abs(man_list[s]) > woman_list[e]:
       ans += 1
       s += 1
       e -= 1
    elif man_list[s] < 0 and 0 < woman_list[e] and abs(man_list[s]) <= woman_list[e]:
        e -= 1
    elif 0 < man_list[s] and woman_list[e] < 0 and man_list[s] < abs(woman_list[e]):
        ans += 1
        s += 1
        e -= 1
    elif 0 < man_list[s] and woman_list[e] < 0 and man_list[s] >= abs(woman_list[e]):
        e -= 1
    elif man_list[s] < 0 and woman_list[e] < 0:
        s += 1
    elif 0 < man_list[s] and 0 < woman_list[e]:
        e -= 1

print(ans)