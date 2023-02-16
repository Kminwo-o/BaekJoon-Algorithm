import sys
input = sys.stdin.readline

N = int(input())
time_lst = [list(map(int, input().split())) for _ in range(N)]

time_lst.sort(key=lambda x : (x[1], x[0]))
cnt = 0
end = 0

for i in range(N):
    if cnt == 0:
        cnt += 1
        end = time_lst[i][1]
        continue

    if time_lst[i][0] >= end:
        cnt += 1
        end = time_lst[i][1]

print(cnt)